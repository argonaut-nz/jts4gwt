# JTS for GWT

This is a library that provides customised JTS 1.13.0 classes for 2 uses in GWT:

1. JRE emulation of the core JTS classes so that your GWT client code can use them (i.e, `Geometry` fields, spatial indexes, etc)
2. GWT-RPC custom serialization of the `Geometry` types:
 * Coordinate
 * LinearRing
 * LineString
 * MultiLineString
 * MultiPoint
 * MultiPolygon
 * Point
 * Polygon

It is based on the original JTS4GWT library that is no longer maintained (see Thanks below).

## Requirements

* GWT >= 2.8.2 (untested on anything lower)
* Java >= 8

## Usage

Gradle `build.gradle`:
```
    /* Used by server for GWT-RPC custom serialization at runtime */
    implementation 'net.sf:jts4gwt:1.13.0'
    
    /* Used by the GWT compiler to generate emulated Javascript and RPC bindings */
    compileOnly 'net.sf:jts4gwt:1.13.0:sources'
```

Maven `pom.xml`:
```
	<dependency>
	  <groupId>net.sf</groupId>
	  <artifactId>jts4gwt</artifactId>
	  <version>1.13.0</version>
	</dependency>
	
	<dependency>
	  <groupId>net.sf</groupId>
	  <artifactId>jts4gwt</artifactId>
	  <version>1.13.0</version>
	  <classifier>sources<classifier>
	  <scope>provided</scope>
	</dependency>
```

GWT `client.gwt.xml`:
```
<inherits name="net.sf.jts4gwt.JTS4GWT" />
```

GWT-RPC DTO:
```
public class Feature {

    public Geometry geometry;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
```

GWT Client:
```
public class Presenter {

    private STRtree index = new STRtree();

    ...
    Point centroid = feature.getGeometry().getCentroid();
    Envelope envelope = feature.getGeometry().getEnvelopeInternal();
    ...
    index.insert(envelope, feature);
    ...
}
```

## Issues

If you discover any GWT compiler errors once you start using more of the JTS classes than we currently do, please raise an issue and we'll try and fix up the code
that needs emulation to run in JavaScript. Or clone this repository and send through a pull request.

## Thanks

The source of this repository was cloned from the original SVN project at https://sourceforge.net/projects/jts4gwt/ by [Alexandre Pretyman](https://sourceforge.net/u/pretyman/profile/).

It was updated to support an upgrade from GWT 2.7 to 2.8 for one of our own projects, as the original JTS4GWT 1.10.2 release has been in use by us since 2012... but it's since
been abandoned in SourceForge. Thanks for your original contribution `pretyman`.