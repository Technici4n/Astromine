package com.github.chainmailstudios.astromine.common.volume.collection;

import java.util.Iterator;
import java.util.Map;

import com.github.chainmailstudios.astromine.common.volume.BaseVolume;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.Direction;

public interface SidedVolumeCollection<T extends BaseVolume> extends Iterable<Map.Entry<Direction, IndexedVolumeCollection<T>>> {
	default IndexedVolumeCollection<T> getCollection(Direction direction) {
		return this.getCollections().get(direction);
	}

	/**
	 * An example implementation of a fromTag method.
	 */
	//static SidedFluidVolumeCollection fromTag(CompoundTag tag) {
	//	SidedFluidVolumeCollection collection = new SimpleSidedFluidVolumeCollection();
	//
	//	for (Direction direction : Direction.values()) {
	//		collection.getCollections().put(direction, IndexedVolumeCollection.fromTag(tag.getCompound(direction.asString())));
	//	}
	//
	//	return collection;
	//

	Map<Direction, IndexedVolumeCollection<T>> getCollections();

	/**
	 * Serializes a SidedVolumeCollection to a tag.
	 *
	 * @return a tag
	 */
	default CompoundTag toTag(CompoundTag tag) {
		for (Map.Entry<Direction, IndexedVolumeCollection<T>> entry : this.getCollections().entrySet()) {
			tag.put(entry.getKey().asString(), entry.getValue().toTag(new CompoundTag()));
		}

		return tag;
	}

	@Override
	default Iterator<Map.Entry<Direction, IndexedVolumeCollection<T>>> iterator() {
		return this.getCollections().entrySet().iterator();
	}
}