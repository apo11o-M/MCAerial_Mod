# MCAerial Mod
---

## Getting Started
### Introduction

### Setup Minecraft Forge, eclipse, and github
MC forge Installation
		Windows, linux, macos
	Eclipse workspace
	Github local & online repos

## Concepts
### Sides
Minecraft are separated to two sides: client and server

**you can skip this part if you just want to add some blocks and items to minecraft as it doesn’t interfere with the server side.

* Logical server - The logical server runs the game logic: mob spawning, weather, inventory updates, health, entities AI and other game mechanics. It is also responsible for maintaining the master copy of the world - updating the blocks and entities based on packets received from the client, and sending updated information to the clients.
* Logical client - The logical client accepts input from the player and relays it to the logical server. It also processes information from the logical server to render the graphics to the player.

In multiplayer, there is one server (in a server room somewhere on earth) and a number of clients (in the players’ PCs) connect to it. In single player there is one server (in your computer) and one client (also in your computer) that are running simultaneously in separate threads.
## Registry handler

	--- construction zone ---

# Items
## Basic Items
Basic items that do not need and special functionality or attributes do not need a custom class. It’s also recommended to create your mod’s general item class since you can put all your custom items and blocks into a dedicated tab in creative mode.
### Advanced items
For more complicated items, you should subclass the Item class and override its methods.

## Tools
For custom tools (swords, axes, pickaxes, etc.), subclass the ItemToolName class and override its methods.
Crafting recipes
To create a custom recipe for your custom items, create a json file in your assets > yourmodid > recipes

### Common issue:
You implemented the recipes but nothing shows up when you’re in the game. It’s possible that you did not specify the state of the blocks you're using (this mostly happens with stone, dirt, and wood as those blocks have different states).  Simply add "data": 0 to the end of the block id to and it should fix the issue.
"item": "minecraft:stone", "data": 0
# Blocks
Basic blocks
For simple blocks (think of cobblestone, dirt, grass, wood, etc.) which do not need any special functionality or attributes, a custom class is not necessary. It’s also recommended to create a general block class for your mod for reasons mentioned above.
Advanced blocks
If you want more functionality (such as interactions with players) then a custom class is required. The Block class has many methods that you can implement to your custom block class.
# BlockItem
A block in a minecraft world and in inventories are very different. A block in the world is represented by a BlockState, controlled by Block class. Whereas an item in an inventory is an ItemStack, a subclass of Item. In between Block and Item class, there exists a class BlockItem. BlockItem is a subclass of Item and has a field block that holds a reference to the Block it presents, it defines some of the behavior of a block as an “item”. To create a BlockItem for a block, use new ItemBlock(block).setRegistryName(this.getRegistryName()) in your block class.
A block with Block class but not BlockItem class will be impossible to hold in inventory. (like minecraft:water exists as a block but can’t hold in an inventory)
# Models
The model system is Minecraft’s way of giving blocks and items their shapes. It is separated into two parts: the model and the texture.
Model Files (.json & .obj files)
A model is simply a shape. Most models in minecraft are .json files and only a few use .obj files as obj is older and doesn’t support many features like animation, materials and lights.
I also suggest downloading the JSON Editor Plugin from Eclipse marketplace. The plugin will highlight your syntax errors in the json files. Otherwise it will be like editing a plain text file with no highlights which is a pain to troubleshoot.

# Texture Files (.png files)
The texture size must be a square and a power of 2, such as 16x16, 32x32, 64x64 etc.
Common issues
If one of the textures is broken, look at the json file. 90% of times a broken texture is because of a faulty json file.
If the texture works in the inventory but not on the ground, check the spelling and run the json validator on the json file in assets.youmodname.models.block.
If the texture works when placed but not in the inventory, check the spelling and run the json validator on the json file in assets.yourname.models.item.
If the texture doesn’t work at all, check the spelling and run the json validator on the json file in assets.yourmodname.blockstates.
If the texture still doesn’t work at all, check your image file, make sure it’s in png format and 16x16px size

# Events
	--- construction zone ---
# Exporting your mod

# Common issues
The command prompt shows “Build fail” when you are trying to export your mod.
* What went wrong:
Execution failed for task ':processResources'.
This is due to an issue with forge 1.12.2 and your mcmod.info file. Change the mcversion to mcversion (...yeah) and it should fix the crash.
"mcversion": "${mcversion}"
