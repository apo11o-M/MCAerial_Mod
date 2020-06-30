package rickwang577.mcaerial.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVehicle extends ModelBase {
	private final ModelRenderer out;
	private final ModelRenderer comp;

	public ModelVehicle() {
		textureWidth = 64;
		textureHeight = 64;

		out = new ModelRenderer(this);
		out.setRotationPoint(6.0F, 23.0F, -6.0F);
		out.cubeList.add(new ModelBox(out, 28, 17, -12.0F, -2.0F, -1.0F, 12, 2, 1, 0.0F, false));
		out.cubeList.add(new ModelBox(out, 28, 13, -12.0F, -3.0F, 12.0F, 12, 3, 1, 0.0F, false));
		out.cubeList.add(new ModelBox(out, 14, 15, -12.0F, -2.0F, 0.0F, 1, 2, 12, 0.0F, false));
		out.cubeList.add(new ModelBox(out, 0, 13, -1.0F, -2.0F, 0.0F, 1, 2, 12, 0.0F, false));

		comp = new ModelRenderer(this);
		comp.setRotationPoint(-5.0F, 21.0F, 0.0F);
		comp.cubeList.add(new ModelBox(comp, 0, 0, 0.0F, 2.0F, -6.0F, 10, 1, 12, 0.0F, false));
		comp.cubeList.add(new ModelBox(comp, 0, 27, 10.0F, -1.0F, 0.0F, 1, 1, 6, 0.0F, false));
		comp.cubeList.add(new ModelBox(comp, 28, 20, -1.0F, -1.0F, 0.0F, 1, 1, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		out.render(f5);
		comp.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}