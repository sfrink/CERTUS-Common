package dto;


import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
	String delimiter = "\n";
	
	public Validator validateString(String str, String label) {
		int stdStrLen = 1024;

		return validateString(str, label, stdStrLen);
	}
	
	public Validator validateString(String str, String label, int maxCharacters) {
		Validator v = new Validator();
		v.setVerified(true);
		v.setStatus("");

		if (str.isEmpty()) {
			v.setVerified(false);
			v.setStatus(label + " field cannot be empty" + delimiter);
		} else if (str.length() > maxCharacters) {
			v.setVerified(false);
			v.setStatus(label + " length cannot be longer than " + maxCharacters
					+ " characters" + delimiter);
		}

		return v;
	}

	public Validator validateStatusInt(int input, String label) {
		int statusActive = 1;
		int statusInactive = 0;
		

		Validator v = new Validator();
		v.setVerified(true);
		v.setStatus("");

		if (input != statusActive && input != statusInactive) {
			v.setVerified(false);
			v.setStatus(label
					+ " has illegal value. Something nasty is happening."
					+ delimiter);
		}

		return v;
	}

	public Validator validateInt(int input, String label) {
		
		Validator v = new Validator();

		v.setVerified(true);
		v.setStatus("");

		if (input < 1) {
			v.setVerified(false);
			v.setStatus("Error " + label
					+ " is not a proper int. Error happened." + delimiter);
		}

		return v;
	}

	public Validator validateDoubleGeneralWithNull(double input, String label) {
		
		Validator v = new Validator();

		v.setVerified(true);
		v.setStatus("");

		if (input < 0) {
			v.setVerified(false);
			v.setStatus("Error " + label
					+ " is not a proper double. Error happened." + delimiter);
		}

		return v;
	}
	
       public Validator validateIntDefault(int input, int defaultValue , String label) {
		
		Validator v = new Validator();

		v.setVerified(true);
		v.setStatus("");

		if (input != defaultValue) {
			v.setVerified(false);
			v.setStatus("Error " + label
					+ " does not hold default value." + delimiter);
		}

		return v;
	}
                
	public Validator validateDoubleGeneral(double input, String label) {
		
		Validator v = new Validator();

		v.setVerified(true);
		v.setStatus("");

		if (input <= 0) {
			v.setVerified(false);
			v.setStatus("Error " + label
					+ " is not a proper double. Error happened." + delimiter);
		}

		return v;
	}

	public Validator validateTimestampGeneral(Timestamp input, String label) {
		
		Validator v = new Validator();

		v.setVerified(true);
		v.setStatus("");

		if (input == null) {
			v.setVerified(false);
			v.setStatus("Error " + label + " is not a proper date." + delimiter);
		}

		return v;
	}

	public Validator validateEmail(String str, String label) {
		
		Validator v = new Validator();

		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(str);

		v.setVerified(false);
		v.setStatus(label + " is not an email of proper form" + delimiter);

		if (matcher.matches()) {
			v.setVerified(true);
			v.setStatus("");
		}

		return v;
	}

}
