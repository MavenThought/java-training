package main.training;

public enum Environments {
	
	PRODUCTION("http://production.site.org", "/var/www/production"),
	UAT       ("http://uat.site.org", "/var/www/uat"),
	TESTING   ("http://testing.local", "/var/www/testing"),
	STAGING   ("http://staging.local", "/home/ubuntu/staging");
	
	private final String url;
	private final String folder;
	
	private Environments(String url, String folder) {
		this.url = url;
		this.folder = folder;
	}

	public boolean needsSSH() {
		return !this.url.contains("local");
	}
	
	public boolean rootAccess() {
		return this.folder.startsWith("/var");
	}
}

