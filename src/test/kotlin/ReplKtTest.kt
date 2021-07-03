import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.io.File


class ReplKtTest {

  private val ndjson = javaClass.getResource("/example.ndjson")!!.toURI().let(::File).let(File::ndjson)

  @Test
  fun testQueries() {
    val q =
      ndjson where { long("size") > 10 } max { long("size") } select { int("id") }
    assertThat(q, equalTo(listOf(214989, 187751, 272714, 322127, 311654, 382626, 357022)))
  }
}