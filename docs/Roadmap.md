#Application Roadmap

##Phase 0
Basic application infrastructure. Simple commands and execution.<br>

- [x] Console shell<br>
- [x] Command parsing<br>
- [ ] CommandExecutor<br>
- [ ] Individual command classes<br>
- [ ] ConsoleOutput helper class<br>
- [ ] Verbose error formatting<br>
- [ ] Auto-generate help from registered commands<br>

##Phase 1
Improvements to command parsing and implementation of file structure and scanning features.<br>

- [ ] Quoted argument parsing<br>
- [ ] File-path validation<br>
- [ ] File scanning<br>
- [ ] Metadata extraction<br>
- [ ] Basic reporting<br>

##Future Plans
Reports - generate reports on libraries (extend to file tree size views)<br>
Metadata - scan files for metadata (codecs, file types, etc) - to be used w/ compatibility<br>
Compatibility - verify compatibility with 3rd party apps (jellyfin, plex, tvs, etc - custom presets)<br>
Automation - renaming, sorting, etc.<br>
GUI - after refining core console commands and logic<br>
Logging - detailed logging, crash reports, user preferences to disable specific logging<br>
Preferences - extend Config to include custom user preferences<br>

##Future Improvements

Consider multi-platform support (see clear() command)<br>
Add ConsoleOutput class - supports single point modification for formatting<br>
CommandHistory - separate into input/execution history in future - detailed logging objects w/ timestamps, success/fail, etc<br>