(sbbin, sbuna) = [new StringBuilder(), new StringBuilder()]
for (char c in new Scanner(System.in).nextLine())
    for (i in 6..0)
        sbbin.append(((int)c >> i) & 1)
bin = sbbin.toString()
for (def (i, count, prev) = [0, 0, (char)'\0']; i < bin.length(); count = (bin[i] == prev ? count : 0) + 1, prev = bin[i++])
    sbuna.append(bin[i] == prev ? "0" : (count ? " " : "") + (bin[i] == '0' as char ? "00 0" : "0 0"))
println sbuna
