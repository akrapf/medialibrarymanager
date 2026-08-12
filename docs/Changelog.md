# MLM ChangeLog
Notes on updates, overall thoughts on each stage.<br>

## v0.2
**DATE HERE**<br>
Implemented Service layer, starting with HistoryService.<br>
Separated input/execution history lists.<br>
Implmented CommandResult for execution result return (currently only status).<br>
Transitioned Console from Switch to full Executor/Service interaction.<br>
Transitioned Testing flag to Tester object, functions as CLI command.<br>
Updated documentation and formatting.<br>
Updates to javadoc.<br>
*Services -> Console -> Executor(Service) as required*
*Command -> Parser -> Executor -> Handler -> Service <- GUI*<br>
*Services visible to GUI & CLI (Console). Handlers and Command related objects exclusive to CLI.*<br>
*Services own and serve data. Executor/Handlers process for CLI*<br>
*Services created in Main, passed to Console to maintain visibility for GUI*<br>
*May end up refactoring history lists into single list of Command objects and execution results*<br>
*CommandResult eventually returns data, status, errors, etc.*<br>
*Considering future Service init loop; try/catch w/ provisions for failed Service startup.*<br>

## v0.1
**7/30/26, but like nearly midnight**<br>
Rough javadoc start. toString on Command object.<br>
Command parsing implemented into `Command[String name, ArrayList<String> arguments]`<br>
Command objected implemented into switch statement.<br>
Better `help()` formatting.<br>
First testing structure started.<br>
Badly written docs/ Roadmap, Command Reference<br>
*Command object -> Parser -> Executor -> Command Class execution*<br>
*Command name validation in Console & Parser, argument validation by Command Classes*<br>


**7/30/26**<br>
First commit of basic console, user input, and Command object structure.<br>
User input enters rudimentary switch statement, calling a respective method.<br>
Basic commands to start: `help, version, history, clear, echo, exit`<br>
*Command object -> Parser -> Command Class execution*<br>