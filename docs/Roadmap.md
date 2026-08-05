# Application Roadmap

General outline of intended progress. Likely badly contextualized.

##v0.1 - Foundation and Skeleton

###v0.1 - Basic application architecture. Simple commands and execution.
- [x] Console shell<br>
- [x] Command parsing<br>
- [x] Command execution<br>
- [x] Individual command classes<br>

###v0.1.1 - Improvements to command parsing.
- [ ] Arguments and Flags<br>
- [ ] Quoted arguments<br>
- [ ] Improvements to help command<br>
- [ ] Verbose command errors<br>

##v0.2 - Core Application Architecture

###v0.2 - Service Layer
- [ ] Service layer interfacing<br>

###v0.2.1 - File System Interaction
- [ ] FileSystem service<br>
- [ ] Directory scanning<br>
- [ ] Basic metadata collection<br>
- [ ] Handle unsupported/inaccessible files<br>

###v0.2.2 - Library Scanning
- [ ] MediaItem data models<br>
- [ ] Scan service <br>
- [ ] Discover Media files<br>
- [ ] Convert Media files to Media objects<br>
- [ ] Display scan results<br>
- [ ] Track scan progress<br>

###v0.2.3 - Query Media
- [ ] Query command<br>
- [ ] Display file metadata<br>

##v0.3 - Library Storage and Management

###v0.3 - Library Database Design
- [ ] Explore database options<br>
- [ ] Design library schema<br>
- [ ] Save/load functionality

###v0.3.1 - to be determined...

##Future Plans
- Command validation, error returns (handler vs service?)<br>
- File-path validation<br>
- ConsoleOutput helper class
Reports - generate reports on libraries (extend to file tree size views)<br>
Metadata - scan files for metadata (codecs, file types, etc) - to be used w/ compatibility<br>
Compatibility - verify compatibility with 3rd party apps (jellyfin, plex, tvs, etc - custom presets)<br>
Automation - renaming, sorting, etc.<br>
GUI - after refining core console commands and logic<br>
Logging - detailed logging, crash reports, user preferences to disable specific logging<br>
Preferences - extend Config to include custom user preferences<br>