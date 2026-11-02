package dev.openvw.data

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SessionTest {
  @Test fun standardLoginKeepsItsOldRule() {
    assertTrue(isLoggedIn(verified = true, alternate = false, installationID = 1, loginId = 1))
    assertFalse(isLoggedIn(verified = true, alternate = false, installationID = 0, loginId = 1))
    assertFalse(isLoggedIn(verified = true, alternate = false, installationID = 1, loginId = 0))
  }

  @Test fun alternateLoginNeedsNoSavwconnectIds() {
    assertTrue(isLoggedIn(verified = true, alternate = true, installationID = 0, loginId = 0))
    assertFalse(isLoggedIn(verified = false, alternate = true, installationID = 0, loginId = 0))
  }
}
