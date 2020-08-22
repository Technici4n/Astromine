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

package com.github.chainmailstudios.astromine.common.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import com.github.chainmailstudios.astromine.common.block.base.TieredHorizontalFacingEnergyMachineBlock;
import com.github.chainmailstudios.astromine.common.network.ticker.NetworkTypeEnergy;

import java.text.DecimalFormat;
import java.util.List;

public class AstromineBlockItem extends BlockItem {
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

	public AstromineBlockItem(Block block, Settings settings) {
		super(block, settings);
	}

	@Environment(EnvType.CLIENT)
	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (getBlock() instanceof TieredHorizontalFacingEnergyMachineBlock) {
			tooltip.add(new TranslatableText("text.astromine.tooltip.speed", DECIMAL_FORMAT.format(((TieredHorizontalFacingEnergyMachineBlock) getBlock()).getMachineSpeed())).formatted(Formatting.GRAY));
			tooltip.add(new LiteralText(" "));
		} else if (getBlock() instanceof NetworkTypeEnergy.EnergyNodeSpeedProvider) {
			tooltip.add(new TranslatableText("text.astromine.tooltip.cable.speed", ((NetworkTypeEnergy.EnergyNodeSpeedProvider) getBlock()).getNodeSpeed()).formatted(Formatting.GRAY));
			tooltip.add(new LiteralText(" "));
		}
		super.appendTooltip(stack, world, tooltip, context);
	}
}