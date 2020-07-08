package rickwang577.mcaerial.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlane extends ModelBase {
	private final ModelRenderer left_main;
	private final ModelRenderer right_main;
	private final ModelRenderer wheels;
	private final ModelRenderer slope;
	private final ModelRenderer center;

	public ModelPlane() {
		textureWidth = 128;
		textureHeight = 128;

		left_main = new ModelRenderer(this);
		left_main.setRotationPoint(6.0F, 22.0F, -5.0F);
		left_main.cubeList.add(new ModelBox(left_main, 0, 47, -3.0F, 1.0F, -3.0F, 3, 1, 1, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 28, 12, -3.4F, -1.0F, 0.0F, 1, 2, 9, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 24, 37, -3.0F, -2.0F, 1.7F, 3, 1, 3, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 0, 37, -3.0F, -1.0F, 3.0F, 3, 3, 3, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 8, 43, -3.0F, -1.0F, -2.0F, 3, 3, 1, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 40, 43, -3.0F, -1.0F, 10.0F, 3, 2, 1, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 0, 12, -3.0F, -1.5F, 0.0F, 3, 1, 11, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 8, 47, -4.0F, -1.0F, -1.0F, 1, 2, 1, 0.0F, false));
		left_main.cubeList.add(new ModelBox(left_main, 0, 31, -3.0F, -3.0F, 8.0F, 3, 2, 4, 0.0F, false));

		right_main = new ModelRenderer(this);
		right_main.setRotationPoint(-3.0F, 22.0F, -5.0F);
		right_main.cubeList.add(new ModelBox(right_main, 48, 43, -3.0F, 1.0F, -3.0F, 3, 1, 1, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 48, 12, -0.6F, -1.0F, 0.0F, 1, 2, 9, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 12, 37, -3.0F, -2.0F, 1.7F, 3, 1, 3, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 42, 31, -3.0F, -1.0F, 3.0F, 3, 3, 3, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 36, 37, -3.0F, -1.0F, -2.0F, 3, 3, 1, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 32, 43, -3.0F, -1.0F, 10.0F, 3, 2, 1, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 34, 0, -3.0F, -1.5F, 0.0F, 3, 1, 11, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 12, 47, 0.0F, -1.0F, -1.0F, 1, 2, 1, 0.0F, false));
		right_main.cubeList.add(new ModelBox(right_main, 52, 24, -3.0F, -3.0F, 8.0F, 3, 2, 4, 0.0F, false));

		wheels = new ModelRenderer(this);
		wheels.setRotationPoint(-4.0F, 24.0F, 3.0F);
		wheels.cubeList.add(new ModelBox(wheels, 24, 43, 8.0F, -2.0F, -8.0F, 2, 2, 2, 0.25F, false));
		wheels.cubeList.add(new ModelBox(wheels, 44, 37, -2.0F, -2.0F, -8.0F, 2, 2, 2, 0.25F, false));
		wheels.cubeList.add(new ModelBox(wheels, 16, 43, 8.0F, -2.0F, -1.0F, 2, 2, 2, 0.25F, false));
		wheels.cubeList.add(new ModelBox(wheels, 0, 43, -2.0F, -2.0F, -1.0F, 2, 2, 2, 0.25F, false));

		slope = new ModelRenderer(this);
		slope.setRotationPoint(4.5F, 20.5F, -4.0F);
		setRotationAngle(slope, 0.2443F, 0.0F, 0.0F);
		slope.cubeList.add(new ModelBox(slope, 28, 31, -1.5F, -0.2819F, -3.0703F, 3, 1, 4, 0.0F, false));
		slope.cubeList.add(new ModelBox(slope, 14, 31, -10.5F, -0.2819F, -3.0703F, 3, 1, 4, 0.0F, false));

		center = new ModelRenderer(this);
		center.setRotationPoint(2.0F, 21.0F, -5.0F);
		center.cubeList.add(new ModelBox(center, 0, 24, -5.0F, -1.5F, 8.0F, 6, 4, 3, 0.0F, false));
		center.cubeList.add(new ModelBox(center, 0, 0, -5.0F, 2.0F, -3.0F, 6, 1, 11, 0.0F, false));
		center.cubeList.add(new ModelBox(center, 18, 24, -4.0F, 0.0F, -2.0F, 4, 2, 5, 0.0F, false));
		center.cubeList.add(new ModelBox(center, 36, 24, -4.0F, -1.0F, -1.0F, 4, 1, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		left_main.render(f5);
		right_main.render(f5);
		wheels.render(f5);
		slope.render(f5);
		center.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}