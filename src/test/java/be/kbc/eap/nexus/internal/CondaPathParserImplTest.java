package be.kbc.eap.nexus.internal;

import be.kbc.eap.nexus.CondaPath;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CondaPathParserImplTest {

    private final CondaPathParserImpl parser = new CondaPathParserImpl();

    @Test
    public void parsesHyphenatedCondaPackageName() {
        CondaPath path = parser.parsePath("noarch/ros-jazzy-slam-interfaces-0.0.1-hb0f4dca_0.conda");

        assertNotNull(path.getCoordinates());
        assertEquals("ros-jazzy-slam-interfaces", path.getCoordinates().getPackageName());
        assertEquals("0.0.1", path.getCoordinates().getVersion());
        assertEquals("hb0f4dca_0", path.getCoordinates().getBuildString());
        assertEquals("conda", path.getCoordinates().getExtension());
    }

    @Test
    public void parsesHyphenatedTarBz2PackageName() {
        CondaPath path = parser.parsePath("noarch/absl-py-0.11.0-pyhd3eb1b0_1.tar.bz2");

        assertNotNull(path.getCoordinates());
        assertEquals("absl-py", path.getCoordinates().getPackageName());
        assertEquals("0.11.0", path.getCoordinates().getVersion());
        assertEquals("pyhd3eb1b0_1", path.getCoordinates().getBuildString());
        assertEquals("tar.bz2", path.getCoordinates().getExtension());
    }
}
