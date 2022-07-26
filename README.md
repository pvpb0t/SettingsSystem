# SettingsSystem
A cool option/setting system in java for modules (aimed at minecraft clients)

Saves all options into configuration files ending with .cllst

Add "OptionConfig.loadOptionConfig();" and Runtime.getRuntime().addShutdownHook(new OptionConfig()); to the initialize event


Looks like following:

![bild](https://user-images.githubusercontent.com/74259011/181017515-8fb163b1-abd9-4495-97c4-0ff5a240e906.png)

Example settings:

![bild](https://user-images.githubusercontent.com/74259011/181017594-c7727648-6695-46c2-a09b-7a3d98f1b5fe.png)

To add settings you would wanna use the following code:
![bild](https://user-images.githubusercontent.com/74259011/181017730-28ef8cf5-f368-4747-be96-90e229d82c6c.png)
