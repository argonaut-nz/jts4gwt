package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom.impl;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

public final class CoordinateArraySequence_CustomFieldSerializer extends CustomFieldSerializer<CoordinateArraySequence> {

    public static void serialize(SerializationStreamWriter streamWriter, CoordinateArraySequence instance) throws SerializationException {
        streamWriter.writeObject(instance.toCoordinateArray());
    }

    public static void deserialize(SerializationStreamReader streamReader, CoordinateArraySequence instance) throws SerializationException {
        /* All handled by instantiate() */
    }

    public static CoordinateArraySequence instantiate(SerializationStreamReader streamReader) throws SerializationException {
        final Coordinate[] coordArr = (Coordinate[]) streamReader.readObject();
        return new CoordinateArraySequence(coordArr);
    }

    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public CoordinateArraySequence instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, CoordinateArraySequence instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, CoordinateArraySequence instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

}
