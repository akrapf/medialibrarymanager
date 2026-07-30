Application Roadmap
--------------------------

PHASE 0:
	> Build command parsing
	> Build basic library scanning, metadata collection

-------------------------------------------------------------


FUTURE PLANS:
	
Reports - generate reports on libraries (extend to file tree size views)
Metadata - scan files for metadata (codecs, file types, etc) - to be used w/ compatibility
Compatibility - verify compatibility with 3rd party apps (jellyfin, plex, tvs, etc - custom presets)
Automation - renaming, sorting, etc.
GUI - after refining core console commands and logic
Logging - detailed logging, crash reports, user preferences to disable specific logging
Preferences - extend Config to include custom user preferences

Future Improvements
----------------------------

Consider multi-platform support (see clear() command)
Add ConsoleOutput class in future - supports single point modification for formatting
CommandHistory - separate into input/execution history in future - detailed logging objects w/ timestamps, success/fail, etc