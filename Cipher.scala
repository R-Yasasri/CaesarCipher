object Cipher extends App {

  var alphabet: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890`~!@#$%^&*_=[]{};:',./?/*-+\\<>\"()";

  val encript = (c: Char, key: Int, a: String) => {
    a((a.indexOf(c.toUpper) + key) % a.size);

  }

  val decript = (c: Char, key: Int, a: String) => {

    var pos: Int = (a.indexOf(c.toUpper) - key) % a.size;

    pos < 0 match {
      case true => a(pos + a.size);
      case false => a(pos);
    }

  }

  val cipher = (algo: (Char, Int, String) => Char, text: String, key: Int, a: String) => {
    text.map(algo(_, key, a));
  }

  // replace "some text to encode@1243 !!" text with a desired text

  val ct = cipher(encript, "Some Text to encode@1234 !!", 5, alphabet);
  println(ct);

  val dt = cipher(decript, ct, 5, alphabet);
  println(dt);


  /*Output from using the sample input
  *
  * XTRJ5YJ2Y5YT5JSHTIJ&67895^^
    SOME TEXT TO ENCODE@1234 !!
  *
  * */
}
