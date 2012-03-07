$(document).bind("mobileinit", function()
{
    $("div[data-role*='page']").live('pageshow', function(event)
    {
        $("input[type='text']:visible:enabled:first").focus();
    });
});