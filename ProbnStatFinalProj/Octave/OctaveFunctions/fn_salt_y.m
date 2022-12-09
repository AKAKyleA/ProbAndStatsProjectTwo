function saltedy = fn_salt_y(y)

  random = rand(1,length(y)); % random vector 0-1
                              %of length y
  saltval = rand(1,length(y));
  saltval = saltval * 1000; %random vector 0-1000

  for i = 1:length(y) % loops through all elements in random

    if random(i) > .5 % if value is > .5

      saltval(i) = saltval(i) - (saltval(i) * 2)
    else  % changes saltval element at postion i to negative

    end
  end

  saltedy = y + saltval; % adds salt value to y

end
