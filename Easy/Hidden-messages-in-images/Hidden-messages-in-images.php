<?php
fscanf(STDIN, "%d %d", $w, $h);
$bytes = array_fill(0, $w * $h >> 3, '');
for ($i = 0; $i < $h; $i++)
    foreach (explode(" ", fgets(STDIN)) as $j => $n)
        $bytes[$i * $w + $j >> 3] .= $n & 1;
echo implode(array_map(function($e){return chr(bindec($e));}, $bytes));
