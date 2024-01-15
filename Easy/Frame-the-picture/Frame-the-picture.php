<?php
function dist_to_edge($y, $x, $h, $w) {
    return min($y, $h - 1 - $y, $x, $w - 1 - $x);
}
$framePattern = stream_get_line(STDIN, 10 + 1, "\n") . ' ';
$pattern_len = strlen($framePattern);
fscanf(STDIN, "%d %d", $h, $w);
for ($i = 0; $i < $h; $i++)
    $pic[$i] = stream_get_line(STDIN, 100 + 1, "\n");
// Top
for ($i = 0; $i < $pattern_len; print "\n", $i++)
    for ($j = 0; $j < $pattern_len * 2 + $w; $j++)
        echo($framePattern[dist_to_edge($i, $j, $pattern_len * 2 + $h, $pattern_len * 2 + $w)]);
// Middle
for ($i = 0; $i < $h; print "\n", $i++) {
    for ($j = 0; $j < $pattern_len; $j++)
        echo($framePattern[$j]);
    for ($j = 0; $j < $w; $j++)
        echo($pic[$i][$j]);
    for ($j = 0; $j < $pattern_len; $j++)
        echo($framePattern[$pattern_len - 1 - $j]);
}
// Bottom
for ($i = $pattern_len + $h; $i < $pattern_len * 2 + $h; print "\n", $i++)
    for ($j = 0; $j < $pattern_len * 2 + $w; $j++)
        echo($framePattern[dist_to_edge($i, $j, $pattern_len * 2 + $h, $pattern_len * 2 + $w)]);
?>
