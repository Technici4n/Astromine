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

package com.github.chainmailstudios.astromine.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

import com.github.chainmailstudios.astromine.AstromineCommon;

public class AstromineSoundEvents {
	public static final SoundEvent EMPTY = register("empty");

	// Tooling
	public static final SoundEvent FIRE_EXTINGUISHER_OPEN = register("fire_extinguisher_open");
	public static final SoundEvent HOLOGRAPHIC_CONNECTOR_CLICK = register("holographic_connector_click");

	// Machinery
	public static final SoundEvent HUMMING = register("humming");

	public static final SoundEvent MACHINE_CLICK = register("block.machine.click");
	public static final SoundEvent INCINERATE = register("block.incinerator.incinerate");

	public static SoundEvent register(String id) {
		return Registry.register(Registry.SOUND_EVENT, AstromineCommon.identifier(id), new SoundEvent(AstromineCommon.identifier(id)));
	}

	public static void initialize() {

	}
}
