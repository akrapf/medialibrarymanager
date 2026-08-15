# Application Roadmap

General outline of intended progress. Likely badly contextualized.

## v0.1 - Foundation and Skeleton

### v0.1 - Basic application architecture. Simple commands and execution.
- [x] Console shell<br>
- [x] Command parsing<br>
- [x] Command execution<br>
- [x] Individual command classes<br>

## v0.2 - Core Application Architecture

### v0.2 - Service Layer Introduction
- [x] Service layer interfacing<br>

### v0.2.1 - Improvements to command parsing
- [x] Arguments and Flags<br>
	- [x] Syntax validation<br>
	- [x] Quoted arguments<br>
	- [x] Exception handling<br>

### v0.2.2 - Command system improvements
- [ ] CommandRegistry<br>
	- [ ] Scalable command definitions<br>
	- [ ] User-configurable command definitions (json)<br>
	- [ ] Programmatic command registration<br>
- [ ] Generate Help from registry<br>
- [ ] Verbose error formatting<br>
	- [ ] OutputHelper class<br>
- [ ] CommandResult expansion<br>
- [ ] Testing platform additions<br>
- [ ] Documentation improvements<br>
- [ ] Javadoc improvements<br>

### v0.2.3 - File System Interaction
- [ ] FileSystem service<br>
- [ ] File path validation<br>
	- [ ] Command sanitization?<br>
- [ ] Directory scanning<br>
- [ ] Basic metadata collection<br>
- [ ] Handle unsupported/inaccessible files<br>
- [ ] Logging?
- [ ] Testing platform additions<br>

### v0.2.4 - Library Scanning
- [ ] MediaItem data models<br>
- [ ] Scan service <br>
- [ ] Discover Media files<br>
- [ ] Convert Media files to Media objects<br>
- [ ] Display scan results<br>
- [ ] Track scan progress<br>
- [ ] Testing platform additions<br>

### v0.2.5 - Query Media
- [ ] Query command<br>
- [ ] Display file metadata<br>
- [ ] Testing platform additions<br>

## v0.3 - Library Storage and Management

### v0.3 - Library Database Design
- [ ] Explore database options<br>
- [ ] Design library schema<br>
- [ ] Save/load functionality
- [ ] Testing platform additions<br>

### v0.3.1 - to be determined...

## Future Plans
- Command validation, error returns (handler vs service?)<br>
- improvements to command parsing (shortcuts, etc)
Reports - generate reports on libraries (extend to file tree size views)<br>
Metadata - scan files for metadata (codecs, file types, etc) - to be used w/ compatibility<br>
Compatibility - verify compatibility with 3rd party apps (jellyfin, plex, tvs, etc - custom presets)<br>
Automation - renaming, sorting, etc.<br>
GUI - after refining core console commands and logic<br>
Logging - detailed logging, crash reports, user preferences to disable specific logging<br>
Preferences - extend Config to include custom user preferences<br>