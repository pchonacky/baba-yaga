package net.chonacky.minecraft.mod.chicken_mod;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelProtoChicken <T extends Entity> extends EntityModel<T>
{
    
	public RendererModel head;
    public RendererModel body;
    public RendererModel rightLeg;
    public RendererModel leftLeg;
    public RendererModel rightShin;
    public RendererModel leftShin;
    public RendererModel leftFoot;
    public RendererModel rightFoot;


    public ModelProtoChicken()
    {   	
	   this.textureWidth = 132;
	   this.textureHeight = 78;
    
	
		this.head = new RendererModel(this, 0, 40);
		this.head.addBox(-12.0F, -6.0F, -12.0F, 24, 14, 24, 0.0F); 
		this.head.setRotationPoint(0.0F, -51.0F, 0.0F);
				
		this.body = new RendererModel(this, 0, 0);
		this.body.addBox(-16.0F, -16.0F, -16.0F, 32, 32, 32, 5.0F); 
		this.body.setRotationPoint(0.0F, -23.0F, 0.0F);

		
	   this.leftLeg = new RendererModel(this, 128,32);
	   this.leftLeg.addBox(0.0F, 0.5F, -0.0F, 1, 13, 1 , 3.0F); 
	   this.leftLeg.setRotationPoint(20.0F, 0.0F, -24.0F);
	   this.body.addChild(this.leftLeg);
   
	   this.rightLeg = new RendererModel(this, 128,32);
	   this.rightLeg.addBox(0.0F, 0.5F, -0.0F, 1, 13, 1 , 3.0F); 
	   this.rightLeg.setRotationPoint(-20.0F, 0.0F, -24.0F);
	   this.body.addChild(this.rightLeg);

	   
	   this.leftShin = new RendererModel(this, 128,32);
	   this.leftShin.addBox(0.0F, -0.5F, 0.0F, 1, 13, 1, 3.0F); 
	   this.leftShin.setRotationPoint(0.0F, 12.0F, 0.0F);
	   this.leftLeg.addChild(this.leftShin);
	   
	   this.rightShin = new RendererModel(this, 128,32);
	   this.rightShin.addBox(0.0F, -0.5F, 0.0F, 1, 13, 1, 3.0F); 
	   this.rightShin.setRotationPoint(0.0F, 12.0F, 0.0F);
	   this.rightLeg.addChild(this.rightShin);

	   
	   this.leftFoot = new RendererModel(this,128,32);
	   this.leftFoot.addBox(0.0F, 1.0F, -0.0F, 1, 4, 1, 3.0F);
	   this.leftFoot.setRotationPoint(0.0F, 14.0F, 0.0F);
	   this.leftShin.addChild(this.leftFoot);	   	
	
	   this.rightFoot = new RendererModel(this,128,32);
	   this.rightFoot.addBox(0.0F, 1.0F, -0.0F, 1, 4, 1, 3.0F);
	   this.rightFoot.setRotationPoint(0.0F, 14.0F, 0.0F);
	   this.rightShin.addChild(this.rightFoot);
    }
 

    @Override
    public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.head.render(scale);
        this.body.render(scale);   
    }


    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, 
    		float netHeadYaw, float headPitch, float scaleFactor )
    {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leftLeg.rotateAngleX =  (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/4);
        this.leftShin.rotateAngleX = -(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/2);
        this.leftFoot.rotateAngleX = -((float)Math.PI/4) ;
        this.rightLeg.rotateAngleX =  -(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/4);
        this.rightShin.rotateAngleX = +(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/2);
        this.rightFoot.rotateAngleX = -((float)Math.PI/4) ;
    }
    
}