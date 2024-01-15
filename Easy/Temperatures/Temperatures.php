<?php
$res = 0;
fscanf(STDIN, "%d", $n);
$inputs = explode(" ", fgets(STDIN));
for ($i = 0; $i < $n; $i++)
{
    $t = intval($inputs[$i]);
    if ($i == 0)
        $res = $t;
    if (abs($t) < abs($res))
        $res = $t;
    if (abs($t) === abs($res))
        $res = max($res, $t);
}
echo "$res\n";
?>
