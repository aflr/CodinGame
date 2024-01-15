<?php
fscanf(STDIN, "%d", $n);
$inputs = explode(" ", fgets(STDIN) ?: '0');
$start = 0; $end = $n - 1; $maxarea = 0;
while ($start < $end) {
    $maxarea = max($maxarea, ($end - $start) * min(intval($inputs[$start]), intval($inputs[$end])));
    $inputs[$start] > $inputs[$end] ? $end-- : $start++;
}
echo("$maxarea\n");
?>
