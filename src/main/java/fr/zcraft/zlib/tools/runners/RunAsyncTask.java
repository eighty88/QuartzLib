/*
 * Copyright or © or Copr. AmauryCarrade (2015)
 * 
 * http://amaury.carrade.eu
 * 
 * This software is governed by the CeCILL-B license under French law and
 * abiding by the rules of distribution of free software.  You can  use, 
 * modify and/ or redistribute the software under the terms of the CeCILL-B
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info". 
 * 
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability. 
 * 
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or 
 * data to be ensured and,  more generally, to use and operate it in the 
 * same conditions as regards security. 
 * 
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-B license and that you accept its terms.
 */
package fr.zcraft.zlib.tools.runners;

import fr.zcraft.zlib.core.ZLib;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;


/**
 * This utility class shortens the code used to execute asynchronous tasks.
 */
public final class RunAsyncTask
{
	private static BukkitScheduler scheduler = Bukkit.getScheduler();

	/**
	 * Returns a task that will run asynchronously on the next server tick.
	 *
	 * <b>Asynchronous tasks should never access any API in Bukkit. Great care should be taken to
	 * assure the thread-safety of asynchronous tasks.</b>
	 *
	 * @param runnable The task to be run.
	 *
	 * @return The BukkitTask that will run.
	 */
	public static BukkitTask nextTick(Runnable runnable)
	{
		return scheduler.runTaskAsynchronously(ZLib.getPlugin(), runnable);
	}

	/**
	 * Returns a task that will run asynchronously after the specified number of server ticks.
	 *
	 * <b>Asynchronous tasks should never access any API in Bukkit. Great care should be taken to
	 * assure the thread-safety of asynchronous tasks.</b>
	 *
	 * @param runnable The task to be run.
	 * @param delay    The ticks to wait before running the task.
	 *
	 * @return The BukkitTask that will run.
	 */
	public static BukkitTask later(Runnable runnable, long delay)
	{
		return scheduler.runTaskLaterAsynchronously(ZLib.getPlugin(), runnable, delay);
	}

	/**
	 * Returns a task that will repeatedly run asynchronously until cancelled, starting after the
	 * specified number of server ticks.
	 *
	 * <b>Asynchronous tasks should never access any API in Bukkit. Great care should be taken to
	 * assure the thread-safety of asynchronous tasks.</b>
	 *
	 * @param runnable The task to be run.
	 * @param wait     The ticks to wait before running the task.
	 * @param period   The ticks to wait between runs
	 *
	 * @return The BukkitTask that will run.
	 */
	public static BukkitTask timer(Runnable runnable, long wait, long period)
	{
		return scheduler.runTaskTimerAsynchronously(ZLib.getPlugin(), runnable, wait, period);
	}
}
