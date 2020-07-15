## MCAerial Mod Documentation
This is the documentation for the MCAerial Mod. It will explain some of the concept of this mod.

### Introduction

To setup a workspace/ compiling from the source
1. Clone mod repository
2. Download Forge
3. Setup: Run [gradle] in repository root:
4. Build: Run [gradle] in the repository root: `gradle build`

A more detailed guide can be found [here](https://forums.minecraftforge.net/topic/13860-tutorial-getting-started-with-forgegradle/)


### Concepts
#### Sides
Here's [Grey's very helpful explanation](http://greyminecraftcoder.blogspot.com/2013/10/client-server-communication-using.html) on the client and server division.

Note: you can skip this part if you just want to add some blocks and items to minecraft as it doesn’t interfere with the server side.


#### Registry handler
Registration is the process of taking the objects of a mod (items, blocks, sounds, etc.) and making them known to the game. Registering things is important, as without registration the game will simply not know about these objects in a mod and will exhibit great amounts of unexplainable behavior (and probably crash).

More details can be found on the [Forge Documentation](https://mcforge.readthedocs.io/en/1.12.x/concepts/registries/)

#### Items
Basic items that do not need and special functionality or attributes do not need a custom class. It’s also recommended to create your mod’s general item class since you can put all your custom items and blocks into a dedicated tab in creative mode.

##### Tools
For custom tools (swords, axes, pickaxes, etc.), subclass the `Item[ToolName]` class and override its methods.

##### Common issue:
You implemented the recipes but nothing shows up when you’re in the game. It’s possible that you did not specify the state of the blocks you're using (this mostly happens with stone, dirt, and wood as those blocks have different states).  Simply add `"data": 0` to the end of the block id to and it should fix the issue.
`"item": "minecraft:stone", "data": 0`


#### Blocks
For simple blocks (think of cobblestone, dirt, grass, wood, etc.) which do not need any special functionality or attributes, a custom class is not necessary. It’s also recommended to create a general block class for your mod for reasons mentioned above.

If you want more functionality (such as interactions with players) then a custom class is required. The `Block` class has many methods that you can implement to your custom block class.

##### ItemBlock
`ItemBlock` is a subclass of `Item` and has a field `block` that holds a reference to the block it presents.

A block with `Block` class but not `ItemBlock` class will be impossible to hold in inventory. (like minecraft:water exists as a block but can’t hold in an inventory)
A more detailed document can be found [here](https://mcforge.readthedocs.io/en/1.12.x/blocks/blocks/)


#### Entity
##### Entity Class
For every entity you create for you mod, you will have to create a new entity class for it. However, be sure to make use of inheritance and various existing entity classes.

##### Render Class
The purpose of the rendering class is to, well, render the model and the texture for the entity; The `doRender` method is mainly responsible for that.

One important concept about rendering is partial ticks. Entities update every 0.05 seconds(1 tick), but the rendering class updates every frame, which is about 60fps for a normal computer. If we only change the rotation for the model every 0.05 seconds then it will have an unpleasant stuttering/ choppy effect. To fix this, we have to interpolate the rotating angle between the first frame and the second frame and rotate the model by that amount as the `doRender` method is called upon every frame in minecraft.


### Models
The model system is Minecraft’s way of giving blocks and items their shapes. It is separated into two parts: the model and the texture.

#### Model Files (.java & .obj files)
A model is simply a shape. Most models in minecraft are .json files and only a few use .obj files as obj is older and doesn’t support many features like animation, materials and lights.

I also suggest downloading the JSON Editor Plugin from Eclipse marketplace. The plugin will highlight your syntax errors in the json files. Otherwise it will be like editing a plain text file with no highlights which is a pain to troubleshoot.

#### Texture Files (.png files)
The texture size must be a square and a power of 2, such as 16x16, 32x32, 64x64 etc.

#### Common issues
If one of the textures is broken, look at the json file. 90% of times a broken texture is because of a faulty json file.

If the texture works in the inventory but not on the ground, check the spelling and run the json validator on the json file in `assets.[youmodname].models.block`.

If the texture works when placed but not in the inventory, check the spelling and run the json validator on the json file in `assets.[yourmodname].models.item`.

If the texture doesn’t work at all, check the spelling and run the json validator on the json file in `assets.[yourmodname].blockstates`.

If the texture still doesn’t work at all, check your image file, make sure it’s in png format and square size


### Events
Minecraft Forge provides event buses that are extremely useful for modders. The general concept is that you create "event handling" methods that subscribe a particular event, and being fired every time that event happens.

One example is the `PlayerUseItemEvent` where the player right clicks while holding an item. The dev can program that something happens when the player is holding a specific item and right clicks.

Here's [Jabelar's tutorial](http://jabelarminecraft.blogspot.com/p/minecraft-forge-172-event-handling.html) on Minecraft Event Handling. It's very helpful and detailed.


### Exporting your mod

#### Common issues
The command prompt shows “Build fail” when you are trying to export your mod.
* What went wrong:
`Execution failed for task ':processResources'`
This is due to an issue with forge 1.12.2 and your mcmod.info file. Change the mcversion to mcversion (...yeah) and it should fix the crash.
`"mcversion": "${mcversion}"`
