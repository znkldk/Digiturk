package com.baris.reportTools;
import com.baris.hook.hook;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class GoogleExel extends hook {

    private  static Sheets sheetsService;
    private  static String APPLICATION_NAME = "yenitest";
    private  static String SPREADSHEET_ID = "1YDdmsbeiwz3J9EcKAF6eUWSbyFIl6WpneU5zgLI-tVM";


    private static Credential authorize() throws IOException, GeneralSecurityException {
        // Load client secrets.
        InputStream in = GoogleExel.class.getResourceAsStream("/credentials.json");

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in));
        List<String> scopes= Arrays.asList(SheetsScopes.SPREADSHEETS);
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
                .authorize("user");
        return credential;
    }
    public static Sheets getSheetsService() throws IOException, GeneralSecurityException{
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),credential).setApplicationName(APPLICATION_NAME).build();
    }

    public void doReport() throws IOException,GeneralSecurityException {
        //Bu kısımda okunan Rapor Google Sheetse yazılmaktadır
        sheetsService = getSheetsService();
        rapor.getErrorMessage();
        ValueRange appendBody =new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList(
                                rapor.getCurrentScenarioName(),
                                rapor.getDate(),
                                rapor.getErrorMessage(),
                                rapor.getResult())));

        AppendValuesResponse appendResult2 =   sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID,"Sayfa1",appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }



}
