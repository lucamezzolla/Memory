package memory;

public enum Language {

	IT("Italiano", "italian.properties"), 
	EN("English", "english.properties"), 
	PT("Portugu\u00EAs", "portog.properties");

	private String languageName;
	private String fileName;

	private Language(String languageName, String fileName) {
		this.languageName = languageName;
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return languageName;
	}

	public String getFileName() {
		return fileName;
	}

	public static String getFileName(String languageName) {
		String fileName = null;
		for (Language l : Language.values()) {
			if (l.toString().equalsIgnoreCase(languageName)) {
				fileName = l.fileName;
				break;
			}
		}
		return fileName;
	}

}