package org.eclipse.jdt.internal.core.pdom.java;

import org.eclipse.jdt.internal.core.pdom.Nd;
import org.eclipse.jdt.internal.core.pdom.field.FieldManyToOne;
import org.eclipse.jdt.internal.core.pdom.field.StructDef;

/**
 * @since 3.12
 */
public final class NdConstantClass extends NdConstant {
	public static final FieldManyToOne<NdTypeSignature> VALUE;

	@SuppressWarnings("hiding")
	public static StructDef<NdConstantClass> type;

	static {
		type = StructDef.create(NdConstantClass.class, NdConstant.type);
		VALUE = FieldManyToOne.create(type, NdTypeSignature.USED_AS_CONSTANT);
		type.done();
	}

	public NdConstantClass(Nd pdom, long address) {
		super(pdom, address);
	}

	protected NdConstantClass(Nd pdom) {
		super(pdom);
	}

	public static NdConstantClass create(Nd pdom, NdTypeSignature value) {
		NdConstantClass result = new NdConstantClass(pdom);
		result.setValue(value);
		return result;
	}

	public void setValue(NdTypeSignature value) {
		VALUE.put(getPDOM(), this.address, value);
	}

	public NdTypeSignature getValue() {
		return VALUE.get(getPDOM(), this.address);
	}
}