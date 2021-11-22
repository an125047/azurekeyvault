package com.example.azurekeyvalutdemo;

import com.azure.core.util.polling.SyncPoller;
import com.azure.identity.*;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.DeletedSecret;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class AzurekeyvalutdemoApplication {

	public static void main(String[] args) {
		//String keyVaultName = System.getenv("KEY_VAULT_NAME");
		String keyVaultUri = "https://acckeyvault3000.vault.azure.net/";

//		IntelliJCredential intelliJCredential = new IntelliJCredentialBuilder()
//				// KeePass configuration isrequired only for Windows. No configuration needed for Linux / Mac.
//				.keePassDatabasePath("C:\\Users\\user\\AppData\\Roaming\\JetBrains\\IdeaIC2021.2\\c.kdbx")
//				.build();

		ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
				.clientId("c22dc1b7-6e88-4b20-b2b2-45fc8f7e1ae9")
				.clientSecret("JPu7Q~2_.VCtn3nuTeOj_CSWhtlfJBZKE0dlc")
				.tenantId("be7cc858-2f26-4ec5-8fef-a3e62aaed8ac")
				.build();

		SecretClient secretClient = new SecretClientBuilder()
				.vaultUrl(keyVaultUri)
				.credential(clientSecretCredential)
				.buildClient();

		Console con = System.console();

		String secretName = "dbpassword";

		System.out.println("Retrieving your secret from acckeyvault2000.");

		KeyVaultSecret retrievedSecret = secretClient.getSecret(secretName);

		System.out.println("Your secret's value is '" + retrievedSecret.getValue() + "'.");
	}

}
