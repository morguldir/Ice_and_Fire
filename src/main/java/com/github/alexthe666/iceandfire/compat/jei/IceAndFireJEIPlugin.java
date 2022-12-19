package com.github.alexthe666.iceandfire.compat.jei;

import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.compat.jei.firedragonforge.FireDragonForgeCatagory;
import com.github.alexthe666.iceandfire.compat.jei.icedragonforge.IceDragonForgeCatagory;
import com.github.alexthe666.iceandfire.compat.jei.lightningdragonforge.LightningDragonForgeCatagory;
import com.github.alexthe666.iceandfire.enums.EnumSkullType;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class IceAndFireJEIPlugin implements IModPlugin {

    public static final ResourceLocation MOD = new ResourceLocation("iceandfire:iceandfire");
    public static final ResourceLocation FIRE_DRAGON_FORGE_ID = new ResourceLocation("iceandfire:fire_dragon_forge");
    public static final ResourceLocation ICE_DRAGON_FORGE_ID = new ResourceLocation("iceandfire:ice_dragon_forge");
    public static final ResourceLocation LIGHTNING_DRAGON_FORGE_ID = new ResourceLocation("iceandfire:lightning_dragon_forge");

    private void addDescription(IRecipeRegistration registry, ItemStack itemStack) {
        registry.addIngredientInfo(itemStack, VanillaTypes.ITEM, new TranslatableComponent(itemStack.getDescriptionId() + ".jei_desc"));
    }

    @SuppressWarnings("deprecation")
    public void registerRecipes(IRecipeRegistration registry) {
        registry.addRecipes(IafRecipeRegistry.FIRE_FORGE_RECIPES, FIRE_DRAGON_FORGE_ID);
        registry.addRecipes(IafRecipeRegistry.ICE_FORGE_RECIPES, ICE_DRAGON_FORGE_ID);
        registry.addRecipes(IafRecipeRegistry.LIGHTNING_FORGE_RECIPES, LIGHTNING_DRAGON_FORGE_ID);
        addDescription(registry, new ItemStack(IafItemRegistry.FIRE_DRAGON_BLOOD.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.ICE_DRAGON_BLOOD.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.LIGHTNING_DRAGON_BLOOD.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_RED.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_BRONZE.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_GRAY.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_GREEN.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_BLUE.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_WHITE.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_SAPPHIRE.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_SILVER.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_ELECTRIC.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_AMYTHEST.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_COPPER.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGONEGG_BLACK.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGON_SKULL_FIRE.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGON_SKULL_ICE.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.DRAGON_SKULL_LIGHTNING.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.FIRE_STEW.get()));
        addDescription(registry, new ItemStack(IafItemRegistry.FROST_STEW.get()));

        for (EnumSkullType skull : EnumSkullType.values()) {
            addDescription(registry, new ItemStack(skull.skull_item.get()));
        }
        for (ItemStack stack : IafRecipeRegistry.BANNER_ITEMS) {
            registry.addIngredientInfo(stack, VanillaTypes.ITEM, new TranslatableComponent("item.iceandfire.custom_banner.jei_desc"));
        }
    }

    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new FireDragonForgeCatagory());
        registry.addRecipeCategories(new IceDragonForgeCatagory());
        registry.addRecipeCategories(new LightningDragonForgeCatagory());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
        registry.addRecipeCatalyst(new ItemStack(IafBlockRegistry.DRAGONFORGE_FIRE_CORE), FIRE_DRAGON_FORGE_ID);
        registry.addRecipeCatalyst(new ItemStack(IafBlockRegistry.DRAGONFORGE_ICE_CORE), ICE_DRAGON_FORGE_ID);
        registry.addRecipeCatalyst(new ItemStack(IafBlockRegistry.DRAGONFORGE_LIGHTNING_CORE), LIGHTNING_DRAGON_FORGE_ID);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return MOD;
    }

}
