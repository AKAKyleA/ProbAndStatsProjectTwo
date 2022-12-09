function [salted, plottedsalt]= fn_plot_salt(x,y)


  salted = fn_salt_y(y); % salts y

  plottedsalt = plot(x,salted);% plots graph
  title('3x + 5 = y salted');% adds title
  set(gca,'fontsize',24);% increases the font
  xlabel('Variable x');% adds x label
  ylabel('Variable y');% adds y label
 
  end
