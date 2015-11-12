

import java.security.MessageDigest

/**
 * @author jham
 */

class Encryption {

  /**
   * Encryption attributes
   */
  val crypt: MessageDigest = MessageDigest.getInstance("MD5")
  var md5hash1: String = _

  /**
   * Default constructor
   */
  def Encryption {
  }

  /**
   * Check password string against a SHA1 conversion
   */
  def checkMD5(password: String) {
    md5hash1 = crypt.digest(password.getBytes).map("%02x".format(_)).mkString
  }

  /**
   * Get encryption
   */
  def getEncryption(): String = {
    md5hash1
  }
}