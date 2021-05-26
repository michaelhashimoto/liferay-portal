import hudson.model.Computer;
import hudson.model.Hudson;
import hudson.model.Node;
import hudson.model.User;

import hudson.slaves.OfflineCause;
import hudson.slaves.OfflineCause.UserCause;

int i = 1;

for (slave in hudson.model.Hudson.instance.slaves) {
	if (i ${compare} ${number}) {
		try {
			slave.getComputer().setTemporarilyOffline(
				${offlineBoolean},
				new UserCause(User.current(), "${offlineReason}"));
		}
		catch (Exception e) {
			System.out.println("Null Slave Found");
		}
	}

	i++;
}