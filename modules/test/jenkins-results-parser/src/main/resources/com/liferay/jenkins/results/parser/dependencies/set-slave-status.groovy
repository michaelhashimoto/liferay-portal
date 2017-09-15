import hudson.slaves.OfflineCause;
import hudson.slaves.OfflineCause.ByCLI;
import hudson.slaves.SlaveComputer;

String slaves = "${slaves}";

for (String slave : slaves.split(",")) {
	Hudson hudson = Hudson.instance;

	Slave slaveObject = hudson.getNode(slave.trim());

	SlaveComputer slaveComputer = slaveObject.getComputer();

	try {
		OfflineCause offlineCause = new OfflineCause.ByCLI("${offline.reason}");

		slaveComputer.setTemporarilyOffline(${offline.status}, offlineCause);
	}
	catch (NullPointerException npe) {
	}
}