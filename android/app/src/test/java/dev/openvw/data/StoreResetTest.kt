package dev.openvw.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StoreResetTest {
  @Test fun resetDropsAccountDataAndKeepsAppSettings() {
    Store.owner = Owner(name = "PREVIOUS DRIVER")
    Store.vehicle = VehicleInfo(vehicleName = "Factory:PREVIOUSVIN")
    Store.parked = Parked(12.0, 77.0, 1L, "Old spot", "")
    Store.live = true
    Store.paintPick = "RED"
    Store.fuelPrice = 105.0

    Store.reset()

    assertEquals(Repo.owner, Store.owner)
    assertEquals(Repo.vehicle, Store.vehicle)
    assertFalse(Store.parkedKnown)
    assertFalse(Store.live)
    assertTrue(Store.paintPick.isEmpty())
    assertEquals(105.0, Store.fuelPrice, 0.0)
  }
}
