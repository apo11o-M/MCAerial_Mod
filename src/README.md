# MCAerial Mod Documentation
This is the documentation for the MCAerial Mod, Minecraft, and Forge.

It's intention is a note for myself as I learned & progress throughout minecraft modding, and it captures my best explanations and practices on those topics.

I also posted some of the most helpful guides and tutorials I found throughout the internet in the bottom of this page. Be sure to check them out!!


## Sides
The minecraft code can be divided into two "sides" - Client and Server
  - The Server side is responsible for running the game logic (mob spawning, weather, updating inventories, health, AI, etc), maintaining the master copy of the world - updating the blocks and entities based on packets received from the client, and sending updated information to all the clients.
  - The Client side is primarily responsible for reading input from the player and for rendering the screen.

In a minecraft single player world, there is one server and one client both running in your computer. In multiplayer mode, there is one server but with multiple clients(players) connect to it.

In order to distinguish between client and server, you use the boolean check `world.isRemote` to check sides. If the field is `true`, the world is currently running on the logical client. If the field is `false`, then the world is running on the logical server.

Now you may ask: *why do we need to check the sides?*

It's because we have to ensure that the game logic and other mechanics only runs on the server side, such as damaging the player every time they walk on your block, or have your machine process dirt into diamonds. Applying game logic to the client side could cause desynchronization (ghost entities, desynchronized stats, etc) in the lightest case, and crashes in the worst case.

More details can be found on [here](http://greyminecraftcoder.blogspot.com/2013/10/client-server-communication-using.html).


## Initialization
During startup, Forge will call your mod several times to add new blocks, items, read configuration files, and integrate itself into the game by registering your classes in the appropriate location.

- PreInitialization - Run before anything else. Read your config, create blocks, items, etc, and register them within the GameRegistry.

- Initialization - Do your mod setup. Build whatever data structures you care about, and register recipes.

- PostInitialization - Handle interaction with other mods.

PreInitialization is performed for all the mods you installed, followed by Initialization for all mods, followed by PostInitialization for all mods. Initializing the mods in `init()` is particularly useful when there might be interactions between multiple mods


## Registry Handler
Registration is the process of taking the objects of a mod (items, blocks, entities, sounds, etc.) and making them known to the game. Registering things is important, as without registration the game will simply not know about these objects in a mod and will exhibit great amounts of unexplainable behavior (and probably crash). The registry process happens in `preInit()`.

More details can be found on the [Forge Documentation](https://mcforge.readthedocs.io/en/1.12.x/concepts/registries/)


## Items
Basic items that do not need and special functionality or attributes do not need a custom class. It’s also recommended to create your mod’s general item class since you can put all your custom items and blocks into a dedicated tab in creative mode.

### Common issue:
You implemented the recipes but nothing shows up when you’re in the game. It’s possible that you did not specify the state of the blocks you're using (this mostly happens with stone, dirt, or colored wool as those blocks have different states). Simply add `"data": 0` to the end of the block id to and it should fix the issue. `"item": "minecraft:stone", "data": 0`


## Blocks
For simple blocks (think of cobblestone, dirt, grass, wood, etc.) which do not need any special functionality or attributes, a custom class is not necessary. It’s also recommended to create a general block class for your mod for reasons mentioned above.

If you want more functionality (such as interactions with players) then a custom class is required. The `Block` class has many methods that you can implement to your custom block class.

One thing to note about blocks is the boundary boxes(hitbox). if one wants to create a block that has a smaller bounding box than a regular full block such as half slabs, then in the block class one would have to declare a new object called `AxisAlignedBB` and override the `getBoundingBox()` method to return the `AxisAlignedBB` field you just declared.

### ItemBlock
`ItemBlock` is a subclass of `Item` and has a field `block` that holds a reference to the block it presents.

A block with `Block` class but not `ItemBlock` class will be impossible to hold in inventory. (like `minecraft:water` exists as a block but can’t hold in an inventory)

A more detailed document can be found [here](https://mcforge.readthedocs.io/en/1.12.x/blocks/blocks/).


## Entity
Entities are one of the most interesting concept in minecraft, and it's so broad, that this doc can't fit every single bit of info into it. So instead, I picked out some of the most important concepts in this class.

`motionX`, `motionY`, `motionZ` - these three fields determines the motion/speed towards the corresponding axis. This is very useful for making vehicles such as cars or airplanes.

`rotationYaw`, `rotationPitch` - the yaw and pitch rotation angle

For `rotationYaw`, 0 degrees at north (Z axis, negative), clockwise is positive, counter-clockwise is negative. When the angle reach 360 degrees, minecraft will convert it into 0 degrees. So there will be no issues where `rotationYaw` gets bigger than 360 degrees.

For `rotationPitch`, 0 degrees at horizontal, look down is positive, look up is negative. So the range is from 180 to -180 degrees

`rotationRoll` - Minecraft does not have rotationRoll integrated into the game, so if one wants to create roll effect, you would have to done it by yourself. Most of the time we use `rotationRoll` for rotating the model and the player's camera.

Rotating the player's model can be done using `RenderPlayerEvent` (see more in [RenderPlayer](https://github.com/apo11o-M/MCAerial_Mod/tree/master/src#renderplayer) ). As for rotating the player's camera, it can be done using the `CameraSetup` event which allows the mod to alter the angle of the player's camera in the yaw, pitch, andÂ roll direction.

`ignoreFrustumCheck` - Since minecraft only render entities whom bounding box are in the player's view, for those whose model significantly exceeds the bounding box, we can set `ignoreFrustumCheck = true` in the constructor so that minecraft will always render the entity's model.


## EventHandlers
Minecraft Forge provides event buses that are extremely useful for modders. The general concept is that you create "event handling" methods that subscribe a particular event, and being fired every time that event happens.

One example is the `PlayerUseItemEvent` where the player right clicks while holding an item. The dev can program that something happens when the player is holding a specific item and right clicks.

Here's [Jabelar's guide](http://jabelarminecraft.blogspot.com/p/minecraft-forge-172-event-handling.html) on Minecraft Event Handling.


## Networking
The client and server are always connected by a network connection(packets).

[Here's my guide](https://gist.github.com/apo11o-M/bec16b08a7cfa43e99820bbe625fec9b) on how to setup SimpleImpl.

For more information go and take a look at the [Forge's documentation](https://mcforge.readthedocs.io/en/1.12.x/networking/simpleimpl/) about networking.


## Guis
### Getting Started
Making blocks with guis can be confusing because there are several things that have to work together. More importantly, you may not need all the complexity depending on what you are trying to achieve.

Before you start, you should know what kind of classes you would/might have to implement.

#### Do you need an `IInventory`
This class holds the information about any stuffs (items or blocks) that are contained inside the block. For example when you put a stack of coal into the furnace it is going into the block's inventory.

#### Do you need a `Container`
If your block have an `IInventory` or a custom gui then `Container` class is a must. It helps combining the inventories and sync them between the client and the server.

#### Do you need a `GuiContainer`
This is where the actual "gui stuff" goes. This class handles the rendering of your custom gui textures, and handles the gui buttons on screen.

#### Do you need a `IGuiHandler`
If you use a `Container` then `IGuiHandler` class is a must. It helps creating network packets to sync up the containers on the client and the server. The `IGuiHandler` also needs a unique GUI ID passed to it as a parameter, so I suggest creating an enum to help manage these IDs.

#### Do you need a `TileEntity`
A tile entity is like a variation of a regular block with IInventory. It is particularly useful if you want to gui to continue to do something even when it isn't open. For example a furnace will continue to cook something even if you are not in the gui.

Examples where no tile entity is needed:

- A simple block that just displays some information in the GUI, like maybe a sign that displays your mod's credits or help info.
- A block where the processing happens instantaneously like a crafting table.

Examples where a tile entity is recommended:
- A block where processing happens over time like cooking in a furnace.

### Implementing Classes
#### `IInventory`
This is fairly simple as we typically just need to extend the existing IInventory classes such as the `InventoryCraftingResult` or the `InventoryEnderChest`. The `IInventory` class is essentially a list that stores a bunch of `ItemStacks` and with many other helper methods that manipulates the list.

#### `Container`
As stated above, this is the class than handles the interactions between the player(client) and the server.

In the constructor we creates `Slots` using the `addSlotToContainer()` method and link the slot to the block's and player's inventory. The slots are the translucent boxes you see when you hover your mouse over some of the container block's guis. It is capable to connect with both the player's and the block's inventory. Note that we also have to specify the on-screen position of the slot.

One thing to note is the `transferStackInSlot()` method. It has to be implemented by the modders since the inherited method doesn't do anything. This method is called when the player wants to move an itemstack from one slot to another. This includes left clicks and shift-clicks. Failure to consider the possibilities would result in weird inventory behaviors such as itemstacks disappearing or even mc stuck in a infinite for loop.

#### `GuiContainer`
This class specifies the layout of the gui, render the background images, retrives items and progress bars for display, amd more.

There are multiple gui drawing methods in the `GUI` class, and each of them have different usages and parameters. For my texture I am using the `drawModalRectWithCustomSizedTexture()` since my texture size is not the minecraft default 176x166 pixels texture size.

I also suggest using GNU Image Manipulation Program (GIMP) or Adobe Photoshop to create your gui textures. You can also go into minecraft's source code, find the original png textures and start from there. It would save you tons of time if you have a template to start with.

To add buttons to the gui, we have to initialize it in the `initGui()` method, create an if block with the button's id, and perform the actions for each buttons.

It's also important to not offset the textures and buttons by absolute pixels, but rather use proportions based on the screen size. This is because each person has different monitor/screen sizes, and different UI size settings. If we uses absolute pixels to off set their position it's very easy to mess up the entire layout for a different window size setting.

Warning: This class only runs on the CLIENT SIDE, so if you want to do stuff that would relate to the server side such as adding items into certain slots, you would have to send a packet to the server side and add the item over there or else your gui would have desyncing issues. I have an example of setting up packets and IMessages in [Networking](https://github.com/apo11o-M/MCAerial_Mod/tree/master/src#networking).

#### `IGuiHandler`
The IGuiHandler provides the Synchronization of the slot contents between the server and client and lets you avoid having to create custom packets. Basically it provides an association between the Container on the server side and the GuiScreen on the client side.

The class check the enumerated ID that is passed into the methods and return the associated element (Container on the server side, or GuiScreen on the client side).


## Rendering Models
There are three parts in rendering objects onto the screen: The render class, the model, and the texture. The render class tells the computer how to render and do transformations on the model. The model is the shape, and the texture is, well, the textures of the model.

### Render Class
The purpose of the rendering class is to render the model and the texture of the entity. The `doRender` method is mainly responsible for that.

The model's rotation is done by using `GlStatemanager.rotate(angle, x, y, z)`. Note the angle is in degrees, and the `x`, `y`, and `z` field indicates which axis the model rotates. Ex. `GlStatemanager.rotate(90F, 0.0F, 1.0F, 0.0F)` means rotate 90 degrees clockwise about the y axis.

### Partial Ticks
Another important concept about rendering is partial ticks. Entities update every 0.05 seconds(1 tick), but the rendering class updates every frame, which is about 60fps for a normal computer. If we only change the rotation for the model every 0.05 seconds then it will have an unpleasant stuttering/ choppy effect. To fix this, we have to interpolate the rotating angle between the first frame and the second frame and rotate the model by that amount as the `doRender` method is called upon every frame in minecraft.

### RenderPlayer
The pivot point of the player's model is located in the center of the feet, and if one want to change the pivot point, just translate the model first, do the rotation, and then translate back. The player model dimension can be found [here](https://www.reddit.com/r/Minecraft/comments/143xdt/how_tall_is_steve/).

One thing to note is that when the program run `GlStateManager.pushMatrix()` in your `RenderPlayerEvent.Pre` event, all of the virtual axis minecraft did previously will be reseted ([Euler Angle Explained](https://en.wikipedia.org/wiki/Euler_angles)), so if we want to rotate the player's model in the pitch and roll direction, we will have to rotate the model in the corresponding yaw angle first, do the pitch and roll, and then undo the yaw rotation we did by rotating in the reverse direction.

Also, be sure to have a variable that indicates the program to pop the matrix in the `RenderPlayerEvent.Post` event. Popping the matrix in the `RenderPlayerEvent.Pre` event will cause GLStackUnderflow error.

So the entire player model rotation process in the `RenderPlayerEvent.Pre` event looks like this:
  1. pushMatrix
  2. rotate in the yaw direction for the virtual axis
  3. translate the model to its pivot point
  4. do your pitch & roll rotation
  5. translate the model back
  6. undo step two by applying the same rotation but in opposite direction  

[Bedrock_Miner](https://bedrockminer.jimdofree.com/modding-tutorials/advanced-modding/vanilla-rendering/) has a detailed guide on using `GlStateManager` class

### Model Files (.java & .obj files)
A model is simply a shape. Most models in minecraft are .json files and only a few use .obj files as obj is older and doesn’t support many features like animation, materials and lights.

I also suggest downloading the JSON Editor Plugin from Eclipse marketplace. The plugin will highlight your syntax errors in the json files. Otherwise it will be like editing a plain text file with no highlights which is a pain to troubleshoot.

### Texture Files (.png files)
The texture size must be a square and a power of 2, such as 16x16, 32x32, 64x64 etc.

Common issues:
  - If one of the textures is broken, look at the json file. 90% of times a broken texture is because of a faulty json file.

  - If the texture works in the inventory but not on the ground, check the spelling and run the json validator on the json file in `assets.[youmodname].models.block`.

  - If the texture works when placed but not in the inventory, check the spelling and run the json validator on the json file in `assets.[yourmodname].models.item`.

  - If the texture doesn’t work at all, check the spelling and run the json validator on the json file in `assets.[yourmodname].blockstates`.

  - If the texture still doesn’t work at all, check your image file, make sure it’s in png format and square size


## Exporting your mod
So you just finished building you mod, and the next step is to export it as .jar file that people can use.
  1. Open you command prompt inside your mod folder
  2. Run `gradlew build`, or `bash gradlew build` if you're running on macOS
  3. Once the build is done, go to your mod folder > build > libs and there will be two files in there. The one with the word "source" is the source code of your mod. KEEP IT! It's the other one that you post online or share to others.

For sharing your mod online, I suggest create an account and upload your file to [Mediafire](https://www.mediafire.com/), and it will generate a link that anyone will be able to access and download.

### Common issues
The command prompt shows “Build fail” when you are trying to export your mod.
* What went wrong:
`Execution failed for task ':processResources'`
This is due to an issue with forge 1.12.2 and your mcmod.info file. Change the mcversion from 1.12.2 to mcversion (...yeah) and it should fix the crash.
`"mcversion": "${mcversion}"`


## Very Helpful Guides/Links
  - [Forge Documentation (1.12.2)](https://mcforge.readthedocs.io/en/1.12.x/) - The official Forge documentation for minecraft 1.12.2 version

  - [Jabelar's Minecraft Forge Modding Tutorials](http://jabelarminecraft.blogspot.com/) - Covered A LOT of topics in Minecraft modding.

  - [TheGreyGhost's Modding Guide](http://greyminecraftcoder.blogspot.com/p/list-of-topics.html) - Similar to Jabelar's tutorials.

  - [TechnoVision Minecraft Modding Tutorials](https://www.youtube.com/playlist?list=PLDhiRTZ_vnoX4bx_BJccGV7MjpXUfVJSn) - Youtube tutorial, very helpful for beginners.

  - [Minecraft Modding by Bedrock_Miner](https://bedrockminer.jimdofree.com/modding-tutorials/) - In depth guide that explains the concepts very well, but it's a bit outdated.

  - [Blockbench](https://blockbench.net/) - A go-to 3D model editor
