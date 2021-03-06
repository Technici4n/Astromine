/*
 * MIT License
 *
 * Copyright (c) 2020 Chainmail Studios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.chainmailstudios.astromine.common.entity.base;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

import com.github.chainmailstudios.astromine.common.component.inventory.FluidInventoryComponent;
import com.github.chainmailstudios.astromine.common.component.inventory.ItemInventoryComponent;
import com.github.chainmailstudios.astromine.registry.AstromineComponentTypes;
import nerdhub.cardinal.components.api.component.ComponentProvider;

public abstract class ComponentFluidItemEntity extends ComponentEntity {
	public ComponentFluidItemEntity(EntityType<?> type, World world) {
		super(type, world);
	}

	public abstract ItemInventoryComponent createItemComponent();

	public abstract FluidInventoryComponent createFluidComponent();

	public ItemInventoryComponent getItemComponent() {
		return ComponentProvider.fromEntity(this).getComponent(AstromineComponentTypes.ITEM_INVENTORY_COMPONENT);
	}

	public FluidInventoryComponent getFluidComponent() {
		return ComponentProvider.fromEntity(this).getComponent(AstromineComponentTypes.FLUID_INVENTORY_COMPONENT);
	}
}
