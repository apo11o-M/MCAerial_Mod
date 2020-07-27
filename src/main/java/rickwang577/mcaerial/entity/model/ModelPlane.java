package rickwang577.mcaerial.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports


public class ModelPlane extends ModelBase {
	private final ModelRenderer MeveModel;
	private final ModelRenderer center_body;
	private final ModelRenderer level_1;
	private final ModelRenderer level_2;
	private final ModelRenderer level_3;
	private final ModelRenderer level_4;
	private final ModelRenderer handlebar_right;
	private final ModelRenderer back_base2;
	private final ModelRenderer back_top2;
	private final ModelRenderer front_base2;
	private final ModelRenderer front_top2;
	private final ModelRenderer handlebar_left;
	private final ModelRenderer back_base3;
	private final ModelRenderer back_top3;
	private final ModelRenderer front_base3;
	private final ModelRenderer front_top3;
	private final ModelRenderer right_wing;
	private final ModelRenderer main;
	private final ModelRenderer sec;
	private final ModelRenderer connection;
	private final ModelRenderer left_wing;
	private final ModelRenderer main2;
	private final ModelRenderer sec2;
	private final ModelRenderer connection2;
	private final ModelRenderer left_wing_tip;
	private final ModelRenderer right_wing_tip;

	public ModelPlane() {
		textureWidth = 128;
		textureHeight = 128;

		MeveModel = new ModelRenderer(this);
		MeveModel.setRotationPoint(0.0F, 23.0541F, -0.3021F);
		MeveModel.cubeList.add(new ModelBox(MeveModel, 21, 26, 22.83F, -2.8648F, 0.2446F, 1, 1, 5, 0.0F, false));
		MeveModel.cubeList.add(new ModelBox(MeveModel, 0, 26, -23.83F, -2.8648F, 0.2446F, 1, 1, 5, 0.0F, false));

		center_body = new ModelRenderer(this);
		center_body.setRotationPoint(0.0F, 0.9459F, 0.3021F);
		MeveModel.addChild(center_body);
		

		level_1 = new ModelRenderer(this);
		level_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		center_body.addChild(level_1);
		level_1.cubeList.add(new ModelBox(level_1, 21, 27, -1.5F, 0.5F, -10.0F, 3, 1, 13, 0.0F, false));
		level_1.cubeList.add(new ModelBox(level_1, 47, 49, 2.5F, 0.0F, -8.0F, 1, 1, 6, 0.0F, false));
		level_1.cubeList.add(new ModelBox(level_1, 47, 37, -3.5F, 0.0F, -8.0F, 1, 1, 6, 0.0F, false));

		level_2 = new ModelRenderer(this);
		level_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		center_body.addChild(level_2);
		level_2.cubeList.add(new ModelBox(level_2, 23, 41, -3.0F, -0.5F, -7.0F, 6, 1, 9, 0.0F, false));
		level_2.cubeList.add(new ModelBox(level_2, 38, 51, -3.0F, -0.5F, 2.0F, 1, 1, 2, 0.0F, false));
		level_2.cubeList.add(new ModelBox(level_2, 0, 46, 2.0F, -0.5F, 2.0F, 1, 1, 2, 0.0F, false));
		level_2.cubeList.add(new ModelBox(level_2, 40, 28, 1.5F, -0.5F, -10.0F, 1, 1, 3, 0.0F, false));
		level_2.cubeList.add(new ModelBox(level_2, 0, 9, 2.0F, -0.5F, -10.0F, 1, 1, 3, 0.0F, false));
		level_2.cubeList.add(new ModelBox(level_2, 0, 40, -2.5F, -0.5F, -10.0F, 1, 1, 3, 0.0F, false));
		level_2.cubeList.add(new ModelBox(level_2, 0, 13, -3.0F, -0.5F, -10.0F, 1, 1, 3, 0.0F, false));
		level_2.cubeList.add(new ModelBox(level_2, 42, 24, -0.5F, -1.0F, -9.0F, 1, 1, 2, 0.0F, false));

		level_3 = new ModelRenderer(this);
		level_3.setRotationPoint(4.0F, -1.0F, -10.0F);
		center_body.addChild(level_3);
		level_3.cubeList.add(new ModelBox(level_3, 40, 18, -8.0F, -0.5F, 3.0F, 8, 1, 9, 0.0F, false));
		level_3.cubeList.add(new ModelBox(level_3, 0, 50, -7.0F, -0.5F, 12.0F, 6, 1, 3, 0.0F, false));
		level_3.cubeList.add(new ModelBox(level_3, 0, 36, -6.0F, -0.5F, 15.0F, 4, 1, 2, 0.0F, false));
		level_3.cubeList.add(new ModelBox(level_3, 40, 32, -5.0F, -0.5F, 17.0F, 2, 1, 2, 0.0F, false));
		level_3.cubeList.add(new ModelBox(level_3, 23, 55, -2.0F, -0.5F, 0.0F, 2, 1, 3, 0.0F, false));
		level_3.cubeList.add(new ModelBox(level_3, 16, 54, -8.0F, -0.5F, 0.0F, 2, 1, 3, 0.0F, false));

		level_4 = new ModelRenderer(this);
		level_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		center_body.addChild(level_4);
		level_4.cubeList.add(new ModelBox(level_4, 0, 26, -2.0F, -2.5F, -10.0F, 4, 1, 13, 0.0F, false));
		level_4.cubeList.add(new ModelBox(level_4, 33, 55, -1.0F, -2.5F, 3.0F, 2, 1, 3, 0.0F, false));

		handlebar_right = new ModelRenderer(this);
		handlebar_right.setRotationPoint(-3.0F, -6.5F, -8.0F);
		center_body.addChild(handlebar_right);
		setRotationAngle(handlebar_right, 0.0F, 0.0524F, -0.0873F);
		

		back_base2 = new ModelRenderer(this);
		back_base2.setRotationPoint(-1.0F, 5.0F, 7.0F);
		handlebar_right.addChild(back_base2);
		setRotationAngle(back_base2, 0.6981F, 0.0F, 0.0F);
		back_base2.cubeList.add(new ModelBox(back_base2, 4, 0, 0.5F, -6.3562F, -0.4622F, 1, 7, 1, 0.0F, false));

		back_top2 = new ModelRenderer(this);
		back_top2.setRotationPoint(0.0F, -1.0F, 4.0F);
		handlebar_right.addChild(back_top2);
		setRotationAngle(back_top2, 1.1345F, 0.0F, 0.0F);
		back_top2.cubeList.add(new ModelBox(back_top2, 30, 32, -0.5F, -2.2787F, -1.9964F, 1, 2, 1, 0.0F, false));

		front_base2 = new ModelRenderer(this);
		front_base2.setRotationPoint(1.0F, 5.0F, -1.0F);
		handlebar_right.addChild(front_base2);
		setRotationAngle(front_base2, -0.1745F, 0.0F, 0.0F);
		front_base2.cubeList.add(new ModelBox(front_base2, 28, 41, -1.5F, -5.0F, 0.0F, 1, 5, 1, 0.0F, false));

		front_top2 = new ModelRenderer(this);
		front_top2.setRotationPoint(-2.0F, 0.0F, 0.0F);
		handlebar_right.addChild(front_top2);
		setRotationAngle(front_top2, -0.9599F, 0.0F, 0.0F);
		front_top2.cubeList.add(new ModelBox(front_top2, 9, 32, 1.5F, -1.8479F, -0.0001F, 1, 2, 1, 0.0F, false));

		handlebar_left = new ModelRenderer(this);
		handlebar_left.setRotationPoint(3.0F, -6.5F, -8.0F);
		center_body.addChild(handlebar_left);
		setRotationAngle(handlebar_left, 0.0F, -0.0524F, 0.0873F);
		

		back_base3 = new ModelRenderer(this);
		back_base3.setRotationPoint(1.0F, 5.0F, 7.0F);
		handlebar_left.addChild(back_base3);
		setRotationAngle(back_base3, 0.6981F, 0.0F, 0.0F);
		back_base3.cubeList.add(new ModelBox(back_base3, 0, 0, -1.5F, -6.3562F, -0.4622F, 1, 7, 1, 0.0F, false));

		back_top3 = new ModelRenderer(this);
		back_top3.setRotationPoint(0.0F, -1.0F, 4.0F);
		handlebar_left.addChild(back_top3);
		setRotationAngle(back_top3, 1.1345F, 0.0F, 0.0F);
		back_top3.cubeList.add(new ModelBox(back_top3, 21, 26, -0.5F, -2.2787F, -1.9964F, 1, 2, 1, 0.0F, false));

		front_base3 = new ModelRenderer(this);
		front_base3.setRotationPoint(-1.0F, 5.0F, -1.0F);
		handlebar_left.addChild(front_base3);
		setRotationAngle(front_base3, -0.1745F, 0.0F, 0.0F);
		front_base3.cubeList.add(new ModelBox(front_base3, 24, 41, 0.5F, -5.0F, 0.0F, 1, 5, 1, 0.0F, false));

		front_top3 = new ModelRenderer(this);
		front_top3.setRotationPoint(2.0F, 0.0F, 0.0F);
		handlebar_left.addChild(front_top3);
		setRotationAngle(front_top3, -0.9599F, 0.0F, 0.0F);
		front_top3.cubeList.add(new ModelBox(front_top3, 0, 26, -2.5F, -1.8479F, -0.0001F, 1, 2, 1, 0.0F, false));

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(0.0F, 0.9459F, 0.3021F);
		MeveModel.addChild(right_wing);
		setRotationAngle(right_wing, 0.0F, -0.0873F, 0.1222F);
		

		main = new ModelRenderer(this);
		main.setRotationPoint(-14.0F, -0.5F, -4.5F);
		right_wing.addChild(main);
		main.cubeList.add(new ModelBox(main, 0, 9, -10.0F, -0.5F, -4.5F, 20, 1, 8, 0.0F, false));

		sec = new ModelRenderer(this);
		sec.setRotationPoint(-4.0F, 0.0F, 8.0F);
		right_wing.addChild(sec);
		setRotationAngle(sec, -0.1745F, 0.0F, 0.0F);
		sec.cubeList.add(new ModelBox(sec, 0, 22, -19.0F, 0.4044F, -8.0521F, 19, 1, 3, 0.0F, false));

		connection = new ModelRenderer(this);
		connection.setRotationPoint(-13.8119F, -1.0F, -1.1548F);
		right_wing.addChild(connection);
		setRotationAngle(connection, -0.0873F, 0.0F, 0.0F);
		connection.cubeList.add(new ModelBox(connection, 28, 28, -0.5872F, 0.0F, 0.0038F, 1, 1, 2, 0.0F, false));

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(0.0F, 0.9459F, 0.3021F);
		MeveModel.addChild(left_wing);
		setRotationAngle(left_wing, 0.0F, 0.0873F, -0.1222F);
		

		main2 = new ModelRenderer(this);
		main2.setRotationPoint(14.0F, -0.5F, -4.5F);
		left_wing.addChild(main2);
		main2.cubeList.add(new ModelBox(main2, 0, 0, -10.0F, -0.5F, -4.5F, 20, 1, 8, 0.0F, false));

		sec2 = new ModelRenderer(this);
		sec2.setRotationPoint(4.0F, 0.0F, 8.0F);
		left_wing.addChild(sec2);
		setRotationAngle(sec2, -0.1745F, 0.0F, 0.0F);
		sec2.cubeList.add(new ModelBox(sec2, 0, 18, 0.0F, 0.4044F, -8.0521F, 19, 1, 3, 0.0F, false));

		connection2 = new ModelRenderer(this);
		connection2.setRotationPoint(13.8119F, -1.0F, -1.1548F);
		left_wing.addChild(connection2);
		setRotationAngle(connection2, -0.0873F, 0.0F, 0.0F);
		connection2.cubeList.add(new ModelBox(connection2, 7, 26, -0.4128F, 0.0F, 0.0038F, 1, 1, 2, 0.0F, false));

		left_wing_tip = new ModelRenderer(this);
		left_wing_tip.setRotationPoint(21.0F, -3.3541F, -3.6979F);
		MeveModel.addChild(left_wing_tip);
		setRotationAngle(left_wing_tip, 0.0F, 0.0F, 0.0873F);
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 48, 9, 9.8657F, 0.328F, -0.0575F, 7, 1, 3, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 24, 47, 19.8657F, 0.328F, 4.9425F, 2, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 44, 20, 19.8657F, 0.328F, 3.9425F, 1, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 44, 44, 1.8657F, 0.328F, -7.0575F, 1, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 48, 5, 1.8657F, 0.328F, -6.0575F, 5, 1, 2, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 29, 36, 9.8657F, 0.328F, -4.0575F, 1, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 29, 51, 9.8657F, 0.328F, -3.0575F, 3, 1, 3, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 7, 29, 6.8657F, 0.328F, -5.0575F, 2, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 0, 44, 12.8657F, 0.328F, -1.0575F, 3, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 21, 29, 12.8657F, 0.328F, -2.0575F, 1, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 0, 29, 16.8657F, 0.328F, 0.9425F, 1, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 28, 26, 16.8657F, 0.328F, 1.9425F, 2, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 40, 28, 1.8657F, 0.328F, -4.0575F, 8, 1, 8, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 0, 32, 16.8657F, 0.328F, 2.9425F, 3, 1, 3, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 41, 18, 3.8657F, 0.328F, 3.9425F, 3, 1, 1, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 21, 36, 6.8657F, 0.328F, 3.9425F, 3, 1, 2, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 0, 54, 9.8657F, 0.328F, 2.9425F, 1, 1, 4, 0.0F, false));
		left_wing_tip.cubeList.add(new ModelBox(left_wing_tip, 44, 44, 10.8657F, 0.328F, 2.9425F, 6, 1, 4, 0.0F, false));

		right_wing_tip = new ModelRenderer(this);
		right_wing_tip.setRotationPoint(-21.0F, -3.3541F, -3.6979F);
		MeveModel.addChild(right_wing_tip);
		setRotationAngle(right_wing_tip, 0.0F, 0.0F, -0.0873F);
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 48, 13, -16.8657F, 0.328F, -0.0575F, 7, 1, 3, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 40, 55, -21.8657F, 0.328F, 4.9425F, 2, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 48, 37, -20.8657F, 0.328F, 3.9425F, 1, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 48, 2, -2.8657F, 0.328F, -7.0575F, 1, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 18, 51, -6.8657F, 0.328F, -6.0575F, 5, 1, 2, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 44, 46, -10.8657F, 0.328F, -4.0575F, 1, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 41, 51, -12.8657F, 0.328F, -3.0575F, 3, 1, 3, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 30, 55, -8.8657F, 0.328F, -5.0575F, 2, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 44, 41, -15.8657F, 0.328F, -1.0575F, 3, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 48, 0, -13.8657F, 0.328F, -2.0575F, 1, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 4, 46, -17.8657F, 0.328F, 0.9425F, 1, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 6, 54, -18.8657F, 0.328F, 1.9425F, 2, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 0, 41, -9.8657F, 0.328F, -4.0575F, 8, 1, 8, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 48, 0, -16.8657F, 0.328F, 2.9425F, 6, 1, 4, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 10, 54, -10.8657F, 0.328F, 2.9425F, 1, 1, 4, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 40, 37, -9.8657F, 0.328F, 3.9425F, 3, 1, 2, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 41, 22, -6.8657F, 0.328F, 3.9425F, 3, 1, 1, 0.0F, false));
		right_wing_tip.cubeList.add(new ModelBox(right_wing_tip, 21, 32, -19.8657F, 0.328F, 2.9425F, 3, 1, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		MeveModel.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}