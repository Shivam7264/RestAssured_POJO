package RentalApi;

import java.util.Random;

public class utilities {
	public static String generateRandomEmail() {

		String[] domains = {
				"@gmail.com", "@yahoo.com", "@outlook.com", "@hotmail.com", "@aol.com"
		};

		Random random = new Random();
		String randomPrefix = generateRandomString(5);
		String randomDomain = domains[random.nextInt(domains.length)];

		// You can add more complexity here (e.g., random numbers, additional characters)

		return randomPrefix + randomDomain;
	}



	public static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			sb.append(randomChar);
		}

		return sb.toString();
	}

}
