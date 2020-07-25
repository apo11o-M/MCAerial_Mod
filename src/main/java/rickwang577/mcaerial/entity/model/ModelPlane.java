package rickwang577.mcaerial.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlane extends ModelBase {
	private final ModelRenderer main_structure;

	public ModelPlane() {
		textureWidth = 32;
		textureHeight = 32;

		main_structure = new ModelRenderer(this);
		main_structure.setRotationPoint(0.0F, 24.0F, 0.0F);
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -4.0F, -1.0F, -6.0F, 8, 1, 12, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, 4.0F, -2.0F, -7.0F, 1, 1, 14, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -5.0F, -2.0F, -7.0F, 1, 1, 14, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -1.0F, -3.0F, -9.0F, 2, 1, 1, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -3.0F, -3.0F, -8.0F, 6, 1, 1, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -2.0F, -2.0F, -8.0F, 4, 1, 1, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -2.0F, -4.0F, -8.0F, 4, 1, 1, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -4.0F, -2.0F, -7.0F, 8, 1, 1, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, -10.0F, -3.0F, -6.0F, 7, 1, 12, 0.0F, false));
		main_structure.cubeList.add(new ModelBox(main_structure, 0, 0, 3.0F, -3.0F, -6.0F, 7, 1, 12, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		main_structure.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}