package general

object leet_389_finddiff {

  def main(args: Array[String]): Unit = {
    var s = "thisistheend"
    var t = "thisihstheend"
    s = ""
    t = "y"
    s = "ihwrdisrhgxwbfevrxbtzgsywhnzleueadikniwyuasflpsviobwvsmydmyzppqjlmzakpbnouyttdigkcdzypvcqxbttmblttehgjlnpjwpzoprntifysfatjboasottnkpyyvmdcafpjicfpgmbwqdsaxdmmdmupnwhkpxixpdwmczntqtushemvavofszomtsrafzmxctpidjadwcwggdbyliqmcvuwscryfsvlvfrhfphmxvcnytbctomicwdwjjmdhmcqtnlqgixxdyjydhwnftkobotbhsgykawhtvnkxoykwkgvtqioqoiilergxlpuujabiug"
    t = "gyptmtjntxlusjhbzkbgowslthwtytdnflsyfsgfytzrodatykdyvgsmvxsuemijitvodmwrrqmcabhwzyoouorfckhisjpduoxvtmttzvwmicdxsovsabmpcpppzycuwbmpihmxadmvkkwerimhgwdwdtvqwbwtetppkpkbcaifuqbenagycdqatklciaczcpglxmvfaqnwpnssdmnhcmifeyndzttvypwlgpttvhswoiijybchbvzklgngqziyaczowgwiufqyhxxdqjrxolddgnmriijopdsikqwtyhplhubrljfjanexxyfvjmudxsomnfbafntpib"

    val out = findTheDifference(s, t)
    println(out)
  }

  def findTheDifference(s: String, t: String): Char = {
    if (s.length + 1 != t.length)
      Char.MaxValue
    else {
      val ss = s.sorted
      val xx = t.sorted
      var output: Char = Char.MaxValue
      var i: Int = 0
      while (i < s.length) {
        if (ss(i) != xx(i)) {
          output = xx(i)
          i = s.length
        }
        else i += 1

      }
      if (output == Char.MaxValue) xx.last else output
    }
  }
}
