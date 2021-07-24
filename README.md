# Dungeons-and-Dragons-2.0

Please see below of my brief description of my Dungeons and Dragons 2.0 application highlighting some of the design patterns that was used, new features that was added, and any software developing techniques/data structures that was utilized. 

New Features that were added from D&D 1.0 to D&D 2.0

The Store: The store serves as the central purpose of buying weapons, selling weapons, and displaying weapon information to the user. The weapon information would include the weapon damage, weapon cost, and what weapon would apply to a particular hero. The store would also indicate if a weapon is avaible to the hero or if a weapon is unavaible to the user. For example, if you are a Mage character trying to buy a weapon for a Healer character, the store would prevent the hero from buying that weapon making the weapon unavaible by setting a conditional varible. Or if the weapon gets destroyed in battle and if the hero chooses to trade in that weapon, the conditional varible will be set to false. 

The Maze Design: The maze design is vastly different from D&D 1.0 to D&D 2.0. The maze design builds off of the individual levels so that for every level it will build off of the previous maze. This was put into place to make the maze unique every level and rather than building a new maze from scratch, this would increase the difficulty incrementally. This was also done such that if modifications were to be made, the modifications could be made at any level of the code or to make a new desgin by a Level 1 to a Level 2 to a Level 3 etc....   Also, the maze is now populated with Monsters[party of 1 or 2], treasure chests, and traps. The monsters would be in a party of 1 or 2 such that a user could fight one monster or a party of monsters. The treasure chests are split up between Low, Medium, or High level chests awarding gold to the party of players pending the chest. The traps are a trap that transports the user to the start, transports the user to a monster, or transports the user to a trap. All traps, monsters, and treasure chests are randomly placed in the maze. 

A more diverse section of weapons for the Monsters & Heros: In this version, there are more diverse weapons for both the Heros and the Monsters. The weapons are split up by the category of Heros. For example, some weapons are for a Mage character or some weapons are for a Healer character. There are also weapons for some monsters in which they are chosen when in battle. Each weapon has a damage amount and a health amount attached to the weapon. 



Design Patterns that was used

Strategy Pattern:
The strategy pattern is used for the both Monsters and the Heros. Specifally, the strategy pattern was used in the attack design philosphy of both the Hero's and the Monster's. After analyzing what would change, it would be the attack behavior of the Hero or Monster and the strategy design pattern was the best choice. 

Simple Factory Pattern: This design pattern was used both for the Hero and the Weapons. For the Hero's, it was used to choose what hero that the user wanted to use. Rather than creating a set of conditionals in the Hero class, specifally this design pattern was used to designate a specific class to handle the different types of Heros to choose. 

For the weapons, this pattern was used to differente what weapon will return for the user when the user chooses from the store. This pattern was used based on the weapon categroy. For example, for all the swords the design pattern was used to differente what swoard the user picked it would be named as SwoardFactory. This would repeat the same behavior for the other subsquent weapons.  

Software Developing Techniques 
SOLID: In this version, I tried my best to follow most of the principle tried to include the different sections. Below will highlight which ones were included in this version

Single Responsibility Principle: In this version, all classes have a single responsibility. The classes are designed with a particular responsibility in mind. For example, the Hero class was designed for a Hero and any attributes of a Hero. The GameFunctionality class was designed for the functionality aspect of the game and won't worry about for example, what specific hero was picked or the design of the maze.

Open Closed Principle: In this aspect, I tried my best to keep my code open for modification but closed for extension. For example, if someone would want to add another Hero. All they would need to do is create a Hero class and add the conditional logic of picking a hero to the HeroFactory class.

Data Structures that was utilized:

HashMap: The hashmap was utilized specifically for the weapons section of the store. I figured that was the best data structure as that allowed a faster implementation when the user would want to buy a weapon, choose a weapon, or if the weapon stats needed to be updated. The structure allowed for a faster lookup of the weapon itself. Also, this would allow me to store the indvidual stats of the weapon itself such that I could modify the weapon stats when needed or to display them when needed to the user.


