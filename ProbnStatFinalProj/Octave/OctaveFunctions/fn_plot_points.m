function plottedgraph = fn_plot_points(x,y)

  plottedgraph = plot(x,y); % plots graph
  title('3x + 5 = y plot'); % adds title
  set(gca,'fontsize',24); % increases the font
  xlabel('Variable x'); % adds x label 
  ylabel('Variable y'); % adds y label
  
  end
