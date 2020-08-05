package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;

public final class Coordinate_CustomFieldSerializer extends CustomFieldSerializer<Coordinate> {

    public static void serialize(SerializationStreamWriter streamWriter, Coordinate instance) throws SerializationException {
        streamWriter.writeDouble(instance.x);
        streamWriter.writeDouble(instance.y);
        streamWriter.writeDouble(instance.z);
    }

    public static void deserialize(SerializationStreamReader streamReader, Coordinate instance) throws SerializationException {
        /* All handled by instantiate() */
    }

    public static Coordinate instantiate(SerializationStreamReader streamReader) throws SerializationException {

        final double x = streamReader.readDouble();
        final double y = streamReader.readDouble();
        final double z = streamReader.readDouble();
        return new Coordinate(x, y, z);
    }

    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public Coordinate instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, Coordinate instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, Coordinate instance) throws SerializationException {
        serialize(streamWriter, instance);
    }
}
