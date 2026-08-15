# Application Architecture

wip...<br>

###CLI Interface Structure
CLI Input > CommandParser > tokenize input > syntax validation & arg classification ><br>
Command object [name, args[], flags{}] > CommandExecutor > registry lookup ><br>
CommandHandler (CLI endpoint) > Services<br>

###GUI Interface Structure
GUI actions interface directly with Services<br>
todo...<br>