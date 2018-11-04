#!/bin/bash
# import multiple remote git repositories to local CODE dir

# settings / change this to your config
remoteHost=github.com
remoteUser=git
remoteDir=ValeriiaMukhina
remoteRepo=spring-boot-sample-web-ui.git
localCodeDir="${HOME}/CODE/"

# for remote repo, check if it exists locally
# assumption: name repo = repo.git, to be saved to repo (w/o .git)
# if dir exists, skip, if not, clone the remote git repo into it

  localRepoDir=$(echo ${localCodeDir}${remoteRepo}|cut -d'.' -f1)
  if [ -d $localRepoDir ]; then 	
		echo -e "Directory $localRepoDir already exists, need to pull ...\n"
		cd $localRepoDir 
		pullCmd="git pull ssh://$remoteUser@$remoteHost/$remoteDir/$remoteRepo"
		pullCmdRun=$($pullCmd 2>&1)
		echo -e "Running: \n$ $pullCmd"
		echo -e "${pullCmdRun}\n\n"
	else
		cloneCmd="git clone ssh://$remoteUser@$remoteHost/$remoteDir/$remoteRepo"
		cloneCmd=$cloneCmd"$gitRepo $localRepoDir"
		
		cloneCmdRun=$($cloneCmd 2>&1)

		echo -e "Running: \n$ $cloneCmd"
		echo -e "${cloneCmdRun}\n\n"
	fi
cd $localRepoDir
#eval "mvn clean install"
applicationProcess=$(ps aux | grep [s]pring-boot-sample-web-ui | awk '{print $2}')
echo $applicationProcess
if [ ! -z "$applicationProcess" ]; then
   eval "kill $applicationProcess"
fi
eval "mvn spring-boot:run &"