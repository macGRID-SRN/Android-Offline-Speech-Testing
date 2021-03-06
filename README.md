##A n d r o i d - O f f l i n e - S p e e c h - T e s t i n g  

### What this project attempts to do

The purpose of this project is to document which tablets/phones have offline
speech capabilities. More specifically to address (this)[http://stackoverflow.com/questions/36776825/android-offline-speech-recognition-without-a-pop-up-dialog] stack overflow post.

### The problem we face

For our project (hitchBOT) we require an Android tablet which can operate without user touch input to do speech recognition. This has to be done online due to the heavy data usage (robot on 24/7) and to reduce power consumption. Unfortunately some tablets and phones seem to work, others don't. Previously we used (this)[http://stackoverflow.com/questions/17616994/offline-speech-recognition-in-android-jellybean] method to enable offline speech, however we don't want to rely on such a hackabout way in the future. We also were only able to get it working with specific version of the Google Search app.
 
### Test Procedure

In order to test your device:

1. Install application either by building from source, or downloading prebuilt apk (here)[]
2. Turn on airplane mode, and ensure tablet/phone has no internet connection
3. launch Device Speech Testing App.
4. Hit button, and talk to device.
5. If you get any results back that aren't an error please let us know to include device in table below.

### The results

| Device  | Android Version  | Has Offline Speech Capabilities  |
|---|---|---|
| One Plus One  | 6.0.1 (CM 13.1.2)  | yes  |
| Galaxy s7 Edge  |   |   |
| Nexus 7 R2  |   |   |
| Samsung Tab A 8" (LTE version)  |   |   |
