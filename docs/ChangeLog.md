# MLM ChangeLog
Notes on updates, overall thoughts on each stage.<br>

**v0.1 - **<br>

**v0.1 - 7/30/26, but like nearly midnight**<br>
Rough javadoc start. toString on Command object.<br>
Command parsing implemented into `Command[String name, ArrayList<String> arguments]`<br>
Command objected implemented into switch statement.<br>
Better `help()` formatting.<br>
First unit testing started.<br>
Badly written docs/ Roadmap, Command Reference<br>
*Command object -> Parser -> Executor -> Command Class execution*<br>
*Command name validation in Console & Parser, argument validation by Command Classes*<br>


**v0.1 - 7/30/26**<br>
First commit of basic console, user input, and Command object structure.<br>
User input enters rudimentary switch statement, calling a respective method.<br>
Basic commands to start: `help, version, history, clear, echo, exit`<br>
*Command object -> Parser -> Command Class execution*<br>